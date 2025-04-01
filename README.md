<strong> **DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNORS UNIVERSITY 
## D308 – MOBILE APPLICATION DEVELOPMENT (ANDROID)
Welcome to Mobile Application Development (Android)! This is an opportunity for students to create page layouts with clean navigation, design mobile application infrastructure and user interfaces, develop secure database-backed mobile applications in an object-oriented language, document solutions for application requirements with storyboards and emulators, articulate challenges in the development process, and describe alternatives methods in overcoming mobile application development problems. 

FOR SPECIFIC TASK INSTRUCTIONS AND REQUIREMENTS FOR THIS ASSESSMENT, PLEASE REFER TO THE COURSE PAGE.
## BASIC INSTRUCTIONS
For this assessment, you have an opportunity to test your competency as a mobile application developer. Your understanding of mobile application structure and design will help you to develop applications to meet customer requirements. This task will allow you to demonstrate your ability to apply the skills learned in the course.

## SUPPLEMENTAL RESOURCES 
1.	How to clone a project to Android Studio using Git?

> Ensure that Android Studio and Git are installed on your system.  New Project, Get from VCS button or the File/New/Project from Version Control. This will open a window  with a prompt to clone the project. Save it in a safe location for the directory and press clone. IntelliJ will prompt you for your credentials. Enter in your WGU Credentials and the project will be cloned onto your local machine.

2. How to create a branch and start Development?

- GitLab method
> Press the '+' button located near your branch name. In the dropdown list, press the 'New branch' button. This will allow you to create a name for your branch. Once the branch has been named, you can select 'Create Branch' to push the branch to your repository.

- Android Studio method
> In Android Studio, Go to the 'Git' button on the top toolbar. Select the new branch option and create a name for the branch. Make sure checkout branch is selected and press create. You can now add a commit message and push the new branch to the local repo.

## SUPPORT
If you need additional support, please navigate to the course page and reach out to your course instructor.
## FUTURE USE
Take this opportunity to create or add to a simple resume portfolio to highlight and showcase your work for future use in career search, experience, and education!

## Task-to-Commit Breakdown:
- **Task B1a:** `ff04c5b` — add vacation entry functionality
- **Task B1b:** `b4fd37b` — Task B1b: add delete button and block deletion logic if excursion exists
- **Task B2:** `b4fd37b` — Task B2: verify existing vacation fields with toString and LogCat
- **Task B3a:** `37cfd95` — Task B3a: add VacationDetailActivity for vacation details and navigation
- **Task B3b:** `2927683` — Task B3b: add vacation editing with update logic
- **Task B3c:** `ab6152d` — Task B3c: add date format validation for vacation input
- **Task B3d:** `4f13e60` — Task B3d: add end date after start date validation
- **Task B3e:** `41fb870` — Task B3e: vacation alerts (start/end) scheduled via AlarmManager + receiver with test code
- **Task B3f:** `4058082` — Task B3f: share vacation info using share intent
- **Task B3g:** `05e2dd0` — Task B3g: create vacation view page for all vacations and each added excursion
- **Task B3h:** `e8ee2c5` — Task B3g (should be B3h): add excursion editing/deleting with ListView on vacation detail screen
- **Task B4:** `52d7470` — Task B4: create clear details for each excursion, including date and title, across activities
- **Task B5a:** `51de01f` — Task B5a: enhance excursion date format and refine title TextView
- **Task B5b:** `eb51bca` — Task B5b: enable editing, adding and deleting excursions for all vacations
- **Task B5c:** `a05c4f6` — Task B5c: add excursion date format validation and input checks
- **Task B5d:** `5a36e1c` — Task B5d: add alert scheduling for excursions
- **Task B5e:** `e563ed3` — Task B5e: validate that excursion dates fall within vacation range
- **Task C:** `989d7a2` — Task C Update: adjust new main menu layout while preserving app functionality
- **Task C:** `206cd24` — Task C Update: compress Save/Delete buttons and remove test screen button
- **Task C:** `83cc062` — Task C Update: add AddVacationActivity and connect to main screen
- **Task C:** `e92da76` — Task C Update: move vacation form to AddVacationActivity
- **Task C:** `b26704d` — Task C Update: remove old vacation form from MainActivity layout and Java
- **Task C:** `93d3668` — Task C Update: add vacation selector screen and create multi-vacation editing
- **Task C:** `1552ea0` — Task C Update: add vacation deletion screen with excursion check and redirect
- **Task C:** `82f916e` — Task C Update: relabel home screen buttons for clarity
- **Task C:** `291e8d1` — Task C Update: add excursion creation from vacation editor screen
- **Task C:** `2006d65` — Task C Update: reorder home buttons and unify delete buttons (black fill)
- **Task C:** `59c0680` — Task C Update: fix inclusive excursion date logic and back button cleanup
- **Task C:** `26ba688` — Task C Update: refactor DeleteVacationActivity to show updated excursion removal
- **Task C:** `a3ea54c` — Task C Final: polish text, method cleanup, add vacation details to excursion edits, fix vacation edit refresh
- **Task D:** `a8bf608` — Task D: add storyboard diagram showing app screen flow and navigation paths (pdf)
- **Task E:** `332293b` — Task E: generate signed APK and document build process with screenshots (word doc)
- **Task F:** `b4d6386` —
  Application Deployment Info (Task F)
  Title: Vacation Planner Mobile App
  Student: Michael Hans
  ID: 001107400

Purpose: 
This app allows users to add, edit, view, and delete vacations and excursions. 
Excursions are validated against vacation date ranges. 
Alerts can be scheduled for start/end of vacations and excursions. 
Vacation details can also be shared using system share options.

How to Operate the Application and Reach Each Rubric Requirement:

Home Screen: 
Central navigation to all features (Add, Edit, Delete, View All).

Vacation Management (Task B1–B3): 
Add/edit/delete vacations. 
Date validation ensures end date is after start. 
Deletion blocked if excursions exist.

Vacation Details (Task B3a–B3f): 
View vacation data, excursions, and access vacation editing.
Set alerts for vacation start and end dates.
Allow vacation data sharing.

Excursion Management (Task B4–B5): 
Add/edit/delete excursions linked to vacations. 
Validates format and ensures excursions fall within vacation date range. 
Set alerts for excursion dates.

Screen Layouts (Task C): 
All five required screen types are represented and navigable.

Storyboard (Task D): 
Draw.io PDF attached to project repository and submitted separately as a PDF.

Signed APK + Screenshots (Task E):
Files represented in project repository.
Screenshots attached to project repository and submitted separately as a Word doc.

Target Android Version:
Built for Android 8.0 (API Level 26)
Developed and tested on Pixel XL emulator, selected for its native API 26 support per WGU recommendations.

Git Repository Link:
https://gitlab.com/wgu-gitlab-environment/student-repos/mhans1/d308-mobile-application-development-android.git

Gitlab repository Web Page:
https://gitlab.com/wgu-gitlab-environment/student-repos/mhans1/d308-mobile-application-development-android/-/tree/D308_MH1?ref_type=heads