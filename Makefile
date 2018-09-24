.PHONY: all build run clean

all: run build

build:
	@mvn package 

run:
	@mvn exec:java -Dexec.mainClass="com.belopopsky.photoBrowser.App"

clean:
	@mvn clean
