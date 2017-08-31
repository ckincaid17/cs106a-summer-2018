# General course information
COURSE_NUMBER = "CS 106A"
COURSE_NAME = "Programming Methodology"
COURSE_TITLE = COURSE_NUMBER + ": " + COURSE_NAME
CS198_NUMBER = 1 # B = 2, X = 3

# General quarter information
QUARTER_NUMBER = 1178
QUARTER_NAME = "Summer"
QUARTER_YEAR = "2017"
QUARTER_FULL_NAME = QUARTER_NAME + " " + QUARTER_YEAR
QUARTER_OVER = True

# Lecture information
LECTURE_DAYS = ["Monday", "Tuesday", "Wednesday", "Thursday"]
LECTURE_TIME = "11:30AM-12:20PM PST"
LECTURE_LOCATION = "NVIDIA Auditorium"
LECTURE_LOCATION_LINK = "https://www.google.com/maps/place/NVIDIA+Auditorium/@37.4277284,-122.1763905,17z/data=!3m1!4b1!4m5!3m4!1s0x808fbb2ac97723cb:0xa6e8fc1a7a5f2c29!8m2!3d37.4277284!4d-122.1741965"
LECTURE_FEEDBACK_LINK = "https://goo.gl/forms/viRkXgYxDRq0Uorm2" # Length > 0

# Course staff
STAFF_INFO = [
	{
		"POSITION": "Instructor",
		"NAME": "Nick Troccoli",
		"IMAGE": "troccoli.jpg",
		"EMAIL": "troccoli@stanford.edu",
		"OFFICE_HOURS_LOCATION": "Gates B02",
		"OFFICE_HOURS_DATETIME": "Wed. + Thurs. 2-4PM",
		"DESCRIPTION": "The instructor teaches lectures and manages the overall course. Contact the instructor if you have a question that cannot be answered by your section leader; the SLs are your primary email contact for all questions about homework or other course issues.  Please also cc your section leader and/or Head TA.  In addition to at his office hours, please feel free to ask Nick questions before/after any lecture."
	},
	{
		"POSITION": "Head TA",
		"NAME": "Rishi Bedi",
		"IMAGE": "rbedi.jpg",
		"EMAIL": "rbedi@stanford.edu",
		"OFFICE_HOURS_LOCATION": "Gates B02",
		"OFFICE_HOURS_DATETIME": "Tues. + Thurs. 9-11AM",
		"DESCRIPTION": "The Head TA manages the section leaders and also oversees important course activities such as grading and section problems. Contact the Head TA if you need a regrade on an assignment, or have a question that cannot be answered by your section leader; the SLs are your primary email contact for all questions about homework or other course issues.  Please also cc your section leader and/or Instructor."
	}
]

SECTION_LEADERS = [
	"Aleksander Dash (adash)",
	"Canyon Robins (crobins)",
	"Conner Smith (csmith95)",
	"Emily Ling (eling8)",
	"Farah Uraizee (farah)",
	"Garrick Fernandez (gfaerr)",
	"Gus Torres da Silva (gdasilva)",
	"Guy Blanc (gblanc)",
	"Jared Bitz (jbitz)",
	"Jestin Ma (jestinm)",
	"Kate Rydberg (rydbergk)",
	"Katherine Erdman (kerdman)",
	"Keanu Spies (keanus)",
	"Michael Hazard (cmhazard)",
	"Mirae Parker (miraep8)",
	"Nick Negrete (nnegrete)",
	"Nolan Handali (nolanh)",
	"Pras Ramakrishnan (pras1712)",
	"Regina Nguyen (renguyen)",
	"Tobin Bell (trfbell)",
	"Tyler Yep (tyep)",
	"Wil Kautz (wkautz)"
]

# SCPD
SCPD_OFFICE_HOURS = [
	"Sun 5:30-7PM PST",
	"Tues 9-11AM PST",
	"Tues 8-9PM PST",
	"Wed 8:30-10PM PST",
	"Thurs 4-5PM PST",
	"Thurs 8:30-9:30PM PST"
]
SCPD_OFFICE_HOURS_LINK = "http://www.queuestatus.com/queues/122"
SCPD_OFFICE_HOURS_DESCRIPTION = "SCPD students can sign up for help at the times above (free QueueStatus account required)."

# Exams
MIDTERM_INFO = {
	"DATE": "Monday, July 24",
	"TIME": "7-9PM PST",
	"LOCATIONS": [
		{
			"TITLE": "Exam",
			"LOCATION": "Hewlett 200"
		}
	],
	"REVIEW_SESSION": {
		"DATE": "Friday, July 21",
		"TIME": "3:30-4:50PM PST",
		"LOCATION": "Gates B03 (basement)"
	}
}

FINAL_EXAM_INFO = {
	"DATE": "Friday, August 18",
	"TIME": "12:15-3:15PM PST",
	"LOCATIONS": [
		{
			"TITLE": "Last Names A-O",
			"LOCATION": "NVIDIA Auditorium"
		},
		{
			"TITLE": "Last Names P-Z",
			"LOCATION": "Gates B01 (Basement)"
		}
	],
	"REVIEW_SESSION": {
		"DATE": "Mon/Tue, August 14-15",
		"TIME": "11:30AM-12:20PM PST",
		"LOCATION": "NVIDIA Auditorium"
	}
}

# Assignments
STYLE_GUIDE = True
PAIR_PROGRAMMING = True
ASSIGNMENTS = [
	{
		"NAME": "Karel the Robot",
		"URL": "karel.html"
	},
	{
		"NAME": "Intro to Java",
		"URL": "introToJava.html"
	},
	{
		"NAME": "Hangman",
		"URL": "hangman.html"
	},
	{
		"NAME": "Artistry and Breakout",
		"URL": "breakout.html"
	},
	{
		"NAME": "ImageShop",
		"URL": "imageshop.html"
	},
	{
		"NAME": "NameSurfer",
		"URL": "namesurfer.html"
	}
]

# Software
SOFTWARE = "Eclipse"
SOFTWARE_ICON = "eclipse-icon.png"
SOFTWARE_LINK = "eclipse"

# Stanford Library
LIBRARY_DOCS_LINK = "http://stanford.edu/~stepp/acmdoc/"

BLANK_PROJECTS = [
	{
		"NAME": "Blank Karel Project",
		"URL": "/resources/BlankKarelProject.zip"
	},
	{
		"NAME": "Blank Java Project",
		"URL": "/resources/BlankJavaProject.zip"
	}
]