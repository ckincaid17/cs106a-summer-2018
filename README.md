# CS106A Summer 2017 Website

This is a pre-compiled, static website for the Summer 2017 offering of
Stanford's CS106A introductory programming course.  This repo is structured as
follows:

```
bottle/ - the source files for Bottle, the library used to compile templates
templates/ - the uncompiled Bottle templates
WWW/ - the output folder containing compiled pages and other static resources
compile.py - the template compilation script
```

## Editing
Within `templates`, there are subfolders for exam pages, assignment pages, and
subparts of various pages.  Here are the relevant files for various tasks you
may want to do:

- **Posting announcements:** add a `<div class="well">` element to
`templates/parts/announcements.html` containing your announcement.  See existing
announcements, as well as `templates/parts/announcements-old.html`, for example
formatting.

- **Adding non-section handouts:** add the handout to `WWW/handouts/` and update
`templates/parts/dropdowns/handoutsDropdownList.html` to list the new handout.

- **Adding section handouts:** add the handout to `WWW/section-handouts/` and
update `templates/parts/dropdowns/sectionMaterialsDropdownList.html` to list the
new handout.

- **Add a new assignment:** add the assignment page template to
`templates/assignments/` and update
`templates/parts/dropdowns/assignmentsDropdownList.html` to list the new
assignment.

- **Change the lecture schedule:** the lecture calendar and the lectures
dropdown are both dynamically generated from the same JSON file,
`schedule.json`.  This JSON file has the following format:

```
{
	"days": ...,
	"weeks": ...
}
```

`days` maps to an array of strings naming each day on which there is lecture.
This is displayed as the header row in the schedule table.  E.g.

```
{
	"days": ["Monday", "Tuesday", "Wednesday", "Thursday"],
	"weeks": ...
}
```

`weeks` is a list containing data for each week.  Each week is itself a list of
objects representing each lecture that week.  These lecture objects have the
following keys:
```
title (REQUIRED) (String): the name of the lecture (or holiday)
date (REQUIRED) (String): the date string (e.g. "June 26") to display
type (OPTIONAL) (String): "HOLIDAY" if a holiday
due (OPTIONAL) (Int): the HW number due today
read (OPTIONAL) (String): the parts of the book (e.g. "Chapter 12") to read
filename (OPTIONAL) (String): the filename prefix for all material filepaths
```

Of note, `filename` is used as follows:
- the lecture PPT is assumed to be at ```{{pathToRoot}}lectures/{{filename}}/{{filename}}.pptx```
- the lecture PDF is assumed to be at ```{{pathToRoot}}lectures/{{filename}}/{{filename}}.pdf```
- the lecture code folder is assumed to be at ```{{pathToRoot}}lectures/{{filename}}/{{filename}}/```
- the lecture code ZIP is assumed to be at ```{{pathToRoot}}lectures/{{filename}}/{{filename}}.zip```

Holidays are grayed out in the calendar and not displayed in the dropdown.  All
information is dynamically displayed from this JSON file for each lecture;
lectures are also numbered automatically.


## Compiling
To compile all references and links to test locally, from the root directory run

```
python compile.py -t --output_dir WWW
```

This compiles all templates in the `templates/` folder and, preserving its
directory structure and filenames, creates all HTML files in the given
output directory.  If no output directory is specified, the files are outputted
to the current directory.

To compile all references and links to host, from the root directory run

```
python compile.py --output_dir WWW
```

This does the same thing as the previous command, but compiles all website URLs
based on the given ROOT constant in `compile.py` instead of local paths.

You may also change any of the default compilation settings in `compile.py`,
including:

```
ROOT - the root URL for the hosted version of this website
OUTPUT_DIR - the default output directory for compiled files
TEMPLATE_DIR - the directory to compile
IGNORE_DIRS - directories within TEMPLATE_DIR that should be ignored
```


## Testing Locally
To host the compiled site locally, from the `WWW/` directory run

`python -m SimpleHTTPServer`

This will host the site on `localhost:8000`.  Make sure to compile using the
`-t` flag beforehand; otherwise the paths will not function properly!

