.PHONY: all build run clean

all: run build

build:
	@mvn compile 

run:
	@mvn exec:java -Dexec.mainClass="com.belopopsky.photoBrowser.App"

clean:
	@mvn clean
