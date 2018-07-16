# General course information
COURSE_NUMBER = "CS 106A"
COURSE_NAME = "Programming Methodology"
COURSE_TITLE = COURSE_NUMBER + ": " + COURSE_NAME
CS198_NUMBER = 1 # B = 2, X = 3

# General quarter information
QUARTER_NUMBER = 1188
QUARTER_NAME = "Summer"
QUARTER_YEAR = "2018"
QUARTER_FULL_NAME = QUARTER_NAME + " " + QUARTER_YEAR
QUARTER_OVER = False  # Set to True to add banner at the top redirecting to newer version of webpage

# Lecture information (displayed at top of home page)
LECTURE_DAYS = ["Monday", "Tuesday", "Wednesday", "Thursday"]
LECTURE_TIME = "11:30AM-12:20PM PST"
LECTURE_LOCATION = "NVIDIA Auditorium"
LECTURE_LOCATION_LINK = "https://www.google.com/maps/place/NVIDIA+Auditorium/@37.4277284,-122.1763905,17z/data=!3m1!4b1!4m5!3m4!1s0x808fbb2ac97723cb:0xa6e8fc1a7a5f2c29!8m2!3d37.4277284!4d-122.1741965"
LECTURE_ASSIGNMENTS_LINK = "hashed-assignments.txt"
LECTURE_FEEDBACK_LINK = "https://docs.google.com/forms/d/e/1FAIpQLSeqfuZy6h7FI5Bbuck20kUOXjeR7pPEdj_DKPBJrHT-PXNHUQ/viewform?usp=sf_link" # Length > 0

# Course staff (displayed in left sidebar and on staff page)
STAFF_INFO = [
	{
		"POSITION": "Instructor",
		"NAME": "Colin Kincaid",
		"IMAGE": "ckincaid.jpg",
		"EMAIL": "ckincaid@stanford.edu",
		"OFFICE_HOURS_LOCATION": "Gates B02",
		"OFFICE_HOURS_DATETIME": "Monday, Thursday 12:30-2:30PM",
		"DESCRIPTION": "The instructor teaches lectures and manages the overall course. Contact the instructor if you have a question that cannot be answered by your section leader; the SLs are your primary email contact for all questions about homework or other course issues.  Please also cc your section leader and/or Head TA.  In addition to at his office hours, please feel free to ask Colin questions before/after any lecture."
	},
	{
		"POSITION": "Head TA",
		"NAME": "Annie Hu",
		"IMAGE": "anniehu.jpg",
		"EMAIL": "anniehu@stanford.edu",
		"OFFICE_HOURS_LOCATION": "Gates B02",
		"OFFICE_HOURS_DATETIME": "Sun 3-5PM, Thu 7-9PM",
		"DESCRIPTION": "The Head TA manages the section leaders and also oversees important course activities such as grading and section problems. Contact the Head TA if you need a regrade on an assignment, or have a question that cannot be answered by your section leader; the SLs are your primary email contact for all questions about homework or other course issues.  Please also cc your section leader and/or instructor."
	}
]

# Note: section leader names MUST be formatted "NAME (SUNET)" as the image for a given Section Leader is assumed to be SUNET.jpg.
SECTION_LEADERS = [
	"Alex Mallery (amallery)",
	"Arjun Sawhney (sawhneya)",
	"Avery Wang (awvry952)",
	"Belce Dogru (belce)",
	"Diego Hernandez (diegoh)",
	"Garrick Fernandez (gfaerr)",
	"Jared Bitz (jbitz)",
	"Jennie Yang (jenniey)",
	"Jesse Doan (jdoan21)",
	"Jonathan Gomes Selman (jgs8)",
	"Matthew Katzman (mkatzman)",
	"Meng Zhang (mz315)",
	"Michelle McGhee (mmcghee)",
	"Ruiqi Chen (rchensix)",
	"Shanon Reckinger (mcintyrs)",
	"Yoni Lerner (yonlern)",
	"Allison Tielking (atielkin)",
	"Connor Meany (cmeany)",
	"Deanna Garcia (dgarcia5)",
	"Greg Ramel (gramel)",
	"Drew Bassilakis (abass20)"
]

SL_INDEX = range(len(SECTION_LEADERS))

# LaIR (listed in left sidebar)
LAIR_HOURS = "Sun-Wed, 7-11PM"

# SCPD (listed in left sidebar)
SCPD_OFFICE_HOURS = []
SCPD_OFFICE_HOURS_LINK = "http://www.queuestatus.com/queues/122"
SCPD_OFFICE_HOURS_DESCRIPTION = "for help during the times below (free QueueStatus account required)."

# Exams (displayed in left sidebar, but locations and review session are only displayed on exam subpages)
MIDTERM = {
	"DATE": "Monday, July 23",
	"TIME": "7-9PM PST",
	"LOCATIONS": [ 	# A list of objects containing TITLE, LOCATION, MAP_LINK
		{
			"TITLE": "Exam",
			"LOCATION": "Hewlett 200",
			"MAP_LINK": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3168.345197243158!2d-122.1750263848679!3d37.42894923975373!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fbb2ae177cc91%3A0x5351ffed56456da8!2sWilliam+R.+Hewlett+Teaching+Center%2C+370+Serra+Mall%2C+Stanford%2C+CA+94305!5e0!3m2!1sen!2sus!4v1500400060838"
		}
	],
	"REVIEW_SESSION": {
		"DATE": "Friday, July 20",
		"TIME": "1:30-2:50PM PST",
		"LOCATION": "Gates B01 (basement)",
		"MAP_LINK": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3168.2942783500653!2d-122.17568493444799!3d37.4301523298236!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fbb2b3f50f727%3A0xfd9cc3200ee97fda!2sGates+Computer+Science%2C+353+Serra+Mall%2C+Stanford%2C+CA+94305!5e0!3m2!1sen!2sus!4v1500425297459"
	}
}

FINAL_EXAM = {
	"DATE": "Friday, August 17",
	"TIME": "12:15-3:15PM PST",
	"LOCATIONS": [	# A list of objects containing TITLE, LOCATION, MAP_LINK
		# {
		# 	"TITLE": "Last Names A-O",
		# 	"LOCATION": "NVIDIA Auditorium",
		# 	"MAP_LINK": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3168.396866793715!2d-122.17639054916224!3d37.42772837972516!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fbb2ac97723cb%3A0xa6e8fc1a7a5f2c29!2sNVIDIA+Auditorium!5e0!3m2!1sen!2sus!4v1502919715852"
		# },
		# {
		# 	"TITLE": "Last Names P-Z",
		# 	"LOCATION": "Gates B01 (Basement)",
		# 	"MAP_LINK": "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3168.2942783500653!2d-122.17568493444799!3d37.4301523298236!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fbb2b3f50f727%3A0xfd9cc3200ee97fda!2sGates+Computer+Science%2C+353+Serra+Mall%2C+Stanford%2C+CA+94305!5e0!3m2!1sen!2sus!4v1500425297459"
		# }
	],
	"REVIEW_SESSION": None
}

# Assignments (displayed in Assignments dropdown at the top)
STYLE_GUIDE = True
PAIR_PROGRAMMING = True
ASSIGNMENTS = [
	{
		"NAME": "Karel the Robot",
		"LINK": "karel.html"
	},
	{
		"NAME": "Intro to Java",
		"LINK": "introToJava.html"
	},
	{
		"NAME": "Snowman",
		"LINK": "snowman.html"
	},
	# {
	# 	"NAME": "Artistry and Breakout",
	# 	"LINK": "breakout.html"
	# },
	# {
	# 	"NAME": "ImageShop",
	# 	"LINK": "imageshop.html"
	# },
	# {
	# 	"NAME": "NameSurfer",
	# 	"LINK": "namesurfer.html"
	# }
]
ASSIGNMENT_DUE_TIME = "11AM PST"

# Software
SOFTWARE = "Eclipse"
SOFTWARE_ICON = "eclipse-icon.png"
SOFTWARE_LINK = "eclipse"

# Stanford Library
LIBRARY_DOCS_LINK = "http://stanford.edu/~stepp/acmdoc/"

BLANK_PROJECTS = [
	{
		"NAME": "Blank Karel Project",
		"LINK": "/resources/BlankKarelProject.zip"
	},
	{
		"NAME": "Blank Java Project",
		"LINK": "/resources/BlankJavaProject.zip"
	}
]
