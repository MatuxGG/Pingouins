default: help

PROJECT_NAME := Pingouins

#
#### General
#


## Compiler le jeu
compile: compile-game compile-tests

## Lancer le jeu
run: java -cp out Pingouins

## Lancer le jeu via jar
start: java -jar Pingouins.jar

#
#### Compilation
#

## Compiler le jeu
compile-game:
	javac -cp src -d out src/*/*/*.java src/*/*/*/*.java src/*/Pingouins.java

## Compiler les tests
compile-tests:
	javac -cp src -d out src/*/*/*.java src/*/Pingouins.java src/*/*/*/*.java src/tests/Tests/*.java
	java -ea -cp out tests.Tests.TestsPingouins
	java -ea -cp out tests.Tests.TestsTerrains
	java -ea -cp out tests.Tests.TestsCoups
	java -ea -cp out tests.Tests.MyTest

# COLORS
GREEN  := $(shell tput -Txterm setaf 2)
YELLOW := $(shell tput -Txterm setaf 3)
WHITE  := $(shell tput -Txterm setaf 7)
RESET  := $(shell tput -Txterm sgr0)
TARGET_MAX_CHAR_NUM=25

help:
	@echo ""
	@echo "#####################"
	@echo "# Project $(PROJECT_NAME) #"
	@echo "#####################"
	@awk '/^### (.*)/ { \
	    print ""; \
	    for (i = 2; i <= NF; i++) {\
	        printf "%s ", $$i; \
	    } \
	    print ""; \
	} \
	/^#### (.*)/ { \
	    printf "\n=============\n "; \
	    for (i = 2; i <= NF; i++) { \
	        printf "%s ", $$i; \
	    } \
	    print "\n============="; \
	} \
	/^[a-zA-Z\-\0-9\/]+:/ { \
	    helpMessage = match(lastLine, /^## (.*)/); \
		if (helpMessage) { \
			helpCommand = substr($$1, 0, index($$1, ":")); \
			helpMessage = substr(lastLine, RSTART + 3, RLENGTH); \
			printf "    ${YELLOW}%-$(TARGET_MAX_CHAR_NUM)s${RESET} ${GREEN}%s${RESET}\n", helpCommand, helpMessage; \
		} \
	} { lastLine = $$0 }' $(MAKEFILE_LIST)