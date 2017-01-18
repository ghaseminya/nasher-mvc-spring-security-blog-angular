# [Nasher](https://github.com/mmghasemi/nasher)
===========================
[![Build Status](https://travis-ci.org/ghaseminya/nasher-mvc-spring-security-blog-angular.svg?branch=master)](https://travis-ci.org/mmghasemi/nasher)
[![Apache License](http://img.shields.io/badge/license-apache2-orange.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
[![Coverage Status](https://coveralls.io/repos/github/ghaseminya/nasher/badge.svg?branch=master)](https://coveralls.io/github/mmghasemi/nasher?branch=master)


Nasher is a light Java blogging system

Admin panel + Home pages

[Demo](http://jnasher.ir) => http://jnasher.ir

[Admin Demo](http://jnasher.ir/admin/index.html)  username/password=mnm

About
-----

The projects aim is to demonstrate the Java implementation of a simple REST interface which is used by an AngularJS application. The following topics are covered:

* A relational database that holds blog posts and users.
* A REST service that exposes the data in the database.
* Authentication and authorization against the REST service.
* A Simple AngularJS application that allows users to view or edit news entries depending on their role.
* A responsive design.

This project is just meant to be a demonstration, therefore it is neither well documented nor well tested. Use it to learn about the technologies used, but do not use it for productive applications.

Any feedback is welcome, and I will incorporate useful pull requests.

Technologies
------------

* [Spring MVC](http://spring.io)
* [AngularJS](http://angularjs.org/)
* [Bootstrap](http://getbootstrap.com/)
* [Jersey](https://jersey.java.net/)
* [Spring Security](http://projects.spring.io/spring-security/)
* [Hibernate](http://hibernate.org/)

User Levels
------------
* User Level = {View posts, Apply new Comment}
* Editor Level = {Add new Post,Edit posts,Delete posts}
* Admin Level = {Manage Users, Posts, Comments, Files, Categories}

Running
-------

Make sure [Maven](http://maven.apache.org/) >= 2.2.1 is installed on your system. Go into the project dir and type `mvn jetty:run`, then point your browser to `http://localhost:8080`.

License
-------

[The Apache Software License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt)
