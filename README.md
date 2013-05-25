groovy-webapp-template
======================

A template for groovy web applications: groovy, spring, hibernate, angular.js

This template uses groovy and the gradle build tool.

Requirements
1) install groovy
2) install gradle

Initialize Your App

1) navigate to directory where you want to create the app and clone this repo

git clone git://github.com/benellingson/groovy-webapp-template.git

2) rename groovy-webapp-template directory 

	mv groovy-webapp-template <your-app-name>

3) change to the application directory

	cd <your-app-name>

4) remove existing git info, so you don't try to commit back to the template

	rm -rf .git

5) initialize source directories

	gradle initapp
	
6) build app

	gradle war
	
7) run app

	gradle runJetty
