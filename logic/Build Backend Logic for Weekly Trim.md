## **Build Backend Logic for Weekly Trimester Content**



* This feature is based on the factors of pregnancy week and user profile, and it should return weekly trimester content. (baby development summary, the symptoms to expect, safe/unsafe tips, and reminders (scheduling appointments, track the vitamins intake)
* The Data Model can look like:

###### *WeeklyContent*

\- id: int

\- week: int

\- trimester: int

\- title: string

\- baby\_dev\_summary: string

\- mom\_changes: string

\- recommended\_actions: string

\- warning\_signs: string





* A Response Example:

{

&nbsp; "week": 9,

&nbsp; "trimester": 1,

&nbsp; "title": "Week 9 – Early Organ Development",

&nbsp; "content": {

&nbsp;   "baby\_dev\_summary": "Your baby is about the size of a grape. Major organs are forming.",

&nbsp;   "mom\_changes": "You may feel fatigue, nausea, and increased sensitivity to smells.",

&nbsp;   "recommended\_actions": "Continue prenatal vitamins, drink enough water, and schedule your first prenatal visit if you haven’t.",

&nbsp;   "warning\_signs": "Contact your provider if you experience heavy bleeding or severe abdominal pain."

&nbsp; }

}





