http://localhost:8080/rest/users/all
[
  {
    "name": "Peter",
    "salary": 2300,
    "links": [
      {
        "rel": "self",
        "href": "http://localhost:8080/rest/users/Peter"
      }
    ]
  },
  {
    "name": "Sam",
    "salary": 2400,
    "links": [
      
    ]
  }
]






http://localhost:8080/rest/users/hateoas/all
[
  {
    "name": "Peter",
    "salary": 2300,
    "links": [
      {
        "rel": "self",
        "href": "http://localhost:8080/rest/users/2300"
      },
      {
        "rel": "salary",
        "href": "http://localhost:8080/rest/users/2300"
      }
    ]
  },
  {
    "name": "Sam",
    "salary": 2400,
    "links": [
      {
        "rel": "self",
        "href": "http://localhost:8080/rest/users/2400"
      }
    ]
  }
]