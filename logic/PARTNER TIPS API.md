## **PARTNER TIPS API**



* This API endpoint takes consideration of multiple factors. Given the pregnancy week and the partner profile, it returns a list of practical tips the partner can use to support the pregnant mother



###### ***PartnerTip***

<i>Considering the information on the tips, I suggest the following fields:</i>

\- id: int

\- week: int                (e.g. 1–40)

\- trimester: int           (e.g. 1, 2, 3)

\- role: string             (e.g. partner)

\- title: string

\- body: string

\- category: string         (e.g. emotional\_support, practical\_help, health\_alert)





##### ***API DESIGN***

***Base Request Url:***

<i>GET /api/partner-tips?week={week}\&language={lang}</i>



<i>**Response Example**</i>

<i>{</i>

<i>  "week": 9,</i>

<i>  "trimester": 1,</i>

<i>  "role": "partner",</i>

<i>  "tips": \[</i>

<i>    {</i>

<i>      "id": 1,</i>

<i>      "title": "Check in on morning sickness",</i>

<i>      "body": "Ask how she’s feeling today and offer to prepare a light snack or ginger tea.",</i>

<i>      "category": "practical\_help"</i>

<i>    },</i>

<i>    {</i>

<i>      "id": 2,</i>

<i>      "title": "Reassure and listen",</i>

<i>      "body": "Hormones may cause mood swings. Listen without trying to fix everything immediately.",</i>

<i>      "category": "emotional\_support"</i>

<i>    }</i>

<i>  ]</i>

<i>}</i>





