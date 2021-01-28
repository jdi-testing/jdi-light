# Changelog

## 1.3.10 (planed July 2020)
* Support [Angular materials](https://material.angular.io/components/categories) elements
* All tasks [angular](https://github.com/jdi-testing/jdi-light/issues?q=is%3Aissue+label%3AAngular+)
* **driver.remote.run** boolean property can be specified in **test.properties** file. If not specified, JDI would use the original logic and switch between local and remote driver depending on other properties

##1.3.3 (04.01.2021)
* Fix small add to WebList issue 

##1.3.1 (09.11.2020)
* Fixed few small internal map issues

##1.3.0 (25.10.2020)
* Important parallelization and stability fix

## 1.2.24 (16.10.2020)
* Bug fix for browserstack

## 1.2.22-23 (release 01.10.2020)
* Fix table indexing for thead tbody tables

## 1.2.21 (release 01.10.2020)
* Make Tables and Data Tables iterable
* Fix @Step issue with JList
* Fix and unify startIndex 0 or 1 for all iterable elements (WebList, JList, DataList, Table, DataTable etc.)
* Add the interface HasStartIndex

## 1.2.20 (release 04.09.2020)
* Add flow strategies for screenshots
* Add flow strategies for elements highlights

## 1.2.19 (release 04.09.2020)
* Bug fix

## 1.2.18 (release 28.08.2020)
* Fix JDITalk
* Fix some error messages
* Improve WebList capabilities
* Update aspectj to 1.9.5
* Prepare 1.2.18 version
* Add WaitAfterAction function (@WaitAfterAction)
* Improve Allure steps logging

## 1.2.17 (release 13.08.2020)
* Bug fix

## 1.2.16 (release 17.05.2020)
* Add keyboard commands (press, command, commands, pasteText) to UIElement
* Add option to take screenshot via Robot

## 1.2.15 (release 08.06.2020)
* Fix list issue with multiple same values

## 1.2.14 (release 31.05.2020)
* Update test properties description and capabilities

## 1.2.13 (release 25.05.2020)
* Update version of AspectJ to 1.9.5. Support JDK 11

## 1.2.11 (release 23.05.2020)
* Technical release

## 1.2.10 (release 21.05.2020)
* Improve tables add footer support and few more locators in JTable #2009

## 1.2.9 (release 05.15.2020)
* Improve bdd steps implementation

## 1.2.8 (release 05.09.2020)
* While test fail Log current page url (if possible) and arguments values in fallen chain

## 1.2.7 (release 05.05.2020)
* Add log option 'log.info.details' for different levels of the element details in logs #1917
* Use methods in JDIAction (Step) in logs #1920
* Fix issue #1916

## 1.2.6 (release 03.05.2020)
* Add Menu2D

## 1.2.5 (release 01.05.2020)
* Add is().expand() / is().collapsed() functionality for all dropdowns
* Fix Smart Search identification for UI_AND_ELEMENTS option
* Add click() method for all Sections
* Add doubleClick(), rightClick(), dragAndDrop() methods for all elements (fot ICoreElement)

## 1.2.4 (release 31.04.2020)
* Fix small issues with dropdowns isEmpty and isNotEmpty for invisible elements

## 1.2.3 (release 22.04.2020)
* Add StartIndex setting #1888
* Fix Download Driver issue. Always set X32 version for Windows #1889
