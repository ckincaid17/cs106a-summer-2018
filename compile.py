#!/usr/bin/env python

'''
FILE: compile.py
----------------
Template compiler that compiles all .html template files in the TEMPLATE_DIR
directory below, excluding IGNORE_DIRS, and outputs with the same filenames to
the OUTPUT_DIR directory.  Example usage:

> python compile.py

Compiles all template files and outputs the compiled files to WWW/.
The compiled files in WWW/ have the same directory structure as in the
TEMPLATE_DIR directory.

> python compile.py  --output_dir myDirectory

Compiles all template files and outputs the compiled files to myDirectory.  The
compiled files in the current directory have the same directory structure as in
the TEMPLATE_DIR directory.
----------------
'''

import os.path
from bottle.bottle import SimpleTemplate
import sys
import json

IGNORE_DIRS = [
    'parts'
]
TEMPLATE_DIR = 'templates'

# Assumed to be within OUTPUT_DIR
HANDOUTS_DIR = 'handouts'

# Use the --output_dir flag to optionally specify where compiled files go
if '--output_dir' in sys.argv:
    OUTPUT_DIR = sys.argv[sys.argv.index('--output_dir') + 1]
else:
    OUTPUT_DIR = 'WWW'

'''
FUNCTION: compile
-----------------
Parameters: NA
Returns: NA

This function compiles all the html files (recursively)
from the templates dir into the current folder. Folder
hierarchy is preserved.
-----------------
''' 
def compile():
    # Read in the announcements and syllabus files
    with open('announcements.json') as announcementsFile: 
        announcementsData = json.load(announcementsFile)   
        with open('schedule.json') as scheduleFile:
            scheduleData = json.load(scheduleFile)

            handoutsData = searchHandoutsDirectory()

            # Compile all templates
            templateFilePaths = getTemplateFilePaths('')
            print("\nCompiling:\n----------")
            for templateFilePath in templateFilePaths:
                outputPath = compileTemplate(templateFilePath, 
                    announcementsData, scheduleData, handoutsData)
                print(templateFilePath + " -> " + outputPath)

    print("\nDONE.\n")

'''
FUNCTION: searchHandoutsDirectory
---------------------------------
Parameters: NA
Returns: a list of tuples containing information about the handouts in
OUTPUT_DIR/HANDOUTS_DIR.  In particular, the tuples are of the format
(handout name, URL).
---------------------------------
'''
def searchHandoutsDirectory():
    handoutsData = []
    handoutsDirPath = OUTPUT_DIR + '/' + HANDOUTS_DIR + '/'
    for fileName in os.listdir(handoutsDirPath):
        if fileName.startswith("."): continue
        filePath = os.path.join(HANDOUTS_DIR, fileName)

        # The name is found by separating each dashed word in the filename
        # except for the first, which is the handout number.  E.g.
        # 1-General-Information.pdf -> 1-General Information
        nameList = os.path.splitext(fileName)[0].split('-')
        handoutName = nameList[0] + ' - ' + ' '.join(nameList[1:])

        handoutsData.append((handoutName, filePath))

    return handoutsData    

'''
FUNCTION: getTemplateFilePaths
------------------------------
Parameters:
    templateRoot - the folder within TEMPLATE_DIR to get file paths for

Returns: a list of template file paths from within the given directory within
    TEMPLATE_DIR.
------------------------------
'''
def getTemplateFilePaths(templateRoot):
    if templateRoot in IGNORE_DIRS: return []
    paths = []
    templateDirPath = os.path.join(TEMPLATE_DIR, templateRoot)
    for fileName in os.listdir(templateDirPath):
        filePath = os.path.join(templateRoot, fileName)
        templateFilePath = os.path.join(TEMPLATE_DIR, filePath)

        # Recurse if it's a directory, add if it's a template file
        if os.path.isdir(templateFilePath):
            childPaths = getTemplateFilePaths(filePath)
            for childPath in childPaths:
                paths.append(childPath)
        elif isTemplateFile(fileName):
            paths.append(filePath)

    return paths

'''
FUNCTION: isTemplateFile
------------------------
Parameters:
    fileName - the fileName to check is a template file

Returns: whether or not the given filename is a template file (ends with .html)
------------------------
'''
def isTemplateFile(fileName):
    extension = os.path.splitext(fileName)[1]
    return extension == '.html'

'''
FUNCTION: compileTemplate
-------------------------
Parameters:
    relativePath - the path within TEMPLATE_DIR of the template file to compile
    announcementsData - the JSON object containing announcements data.  Passed
                        in as a parameter to render the template.
    scheduleData - the JSON object containing schedule data.  Passed in as a
                    parameter to render the template.
    handoutsData - the list of tuples of handout data.  Passed in as a parameter
                    to render the template.

Returns: the path of the saved, compiled template file.

Compiles the given template file using Bottle's SimpleTemplate class, passing
in announcementsData, scheduleData and handoutsData as template parameters.
Saves the compiled template to relativePath in the OUTPUT_DIR directory.
-------------------------
'''
def compileTemplate(relativePath, announcementsData, scheduleData,
    handoutsData):
    filePath = os.path.join(TEMPLATE_DIR, relativePath)
    templateText = open(filePath).read()
    compiledHtml = SimpleTemplate(templateText).render(
        announcements=announcementsData, schedule=scheduleData,
        handouts=handoutsData)
    compiledHtml = compiledHtml.encode('utf8')

    relativePath = os.path.join(OUTPUT_DIR, relativePath)
    makePath(relativePath)
    open(relativePath, 'wb').write(compiledHtml)
    return relativePath
    
'''
FUNCTION: makePath
------------------
Parameters:
    path - the path to make directories for

Returns: NA

Creates all needed directories in this path for the directory path to exist.
E.g. if path = 'stuff/moreStuff/index.html' then the stuff and moreStuff
directories would be created if they did not already exist.
------------------
'''
def makePath(path):
    dirPath = os.path.dirname(path)
    if dirPath != '' and not os.path.exists(dirPath):
        os.makedirs(dirPath)


if __name__ == '__main__':
    compile()
