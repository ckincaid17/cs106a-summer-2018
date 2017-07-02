<nav class="navbar navbar-inverse">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand brand" href="{{pathToRoot}}">CS 106A</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <!-- Lectures dropdown -->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						Lectures <span class="caret"></span>
		  			</a>
                    <ul class="dropdown-menu">
                        %include templates/parts/dropdowns/lecturesDropdownList.tpl
                    </ul>
                </li>

                <!-- Handouts dropdown -->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						Handouts <span class="caret"></span>
		  			</a>
                    <ul class="dropdown-menu">
                        % for handout in handouts:
                    	    <li><a href="{{pathToRoot}}{{handout[1]}}">{{handout[0]}}</a></li>
                        % end
                    </ul>
                </li>

                <!-- Assignments dropdown -->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                    	Assignments <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        %include templates/parts/dropdowns/assignmentsDropdownList.tpl
                        <li class="divider"></li>
                        <li><a href="{{pathToRoot}}styleguide.html">Style Guide</a></li>
                    </ul>
                </li>

                <!-- Section dropdown -->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                    	Section <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        %include templates/parts/dropdowns/sectionMaterialsDropdownList.tpl
                        <li class="divider"></li>
                        <li><a href="https://cs198.stanford.edu/cs198/auth/section/SwitchSection.aspx?class=1">Late Section Signup</a></li>
                        <li><a href="https://cs198.stanford.edu/cs198/auth/section/RemoteSignup.aspx?class=1">Late SCPD Signup</a></li>
                        <li><a href="https://cs198.stanford.edu/cs198/auth/section/SwitchSection.aspx?class=1">Individual Section Swap</a></li>
                        <li><a href="https://cs198.stanford.edu/cs198/auth/default.aspx">View My Section</a></li>
                        <li><a href="https://cs198.stanford.edu/cs198/auth/section/ViewSections.aspx?class=1">List of all section times/locations</a></li>
                        <li><a href="https://cs198.stanford.edu/cs198/auth/section/DropClass.aspx?class=1">Drop Section</a></li>
                    </ul>
                </li>
            </ul>

            <!-- Schedule button -->
            <ul class="nav navbar-nav navbar-right">
                <li><a href="{{pathToRoot}}schedule.html"><span class="glyphicon glyphicon-th-large" aria-hidden="true"></span> Schedule</a></li>
            </ul>

        </div>
    </div>
</nav>