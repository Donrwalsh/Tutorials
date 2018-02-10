# Java for Dummies, 7th Ed

***

## Chapter 2: ~Getting Setup

- My Mac had Java 8 Update 161 installed.
- Updated to 9.0.4 by downloading the SDK directly.
- All this seems fine, no weirdness to be noted.

- Armed with a whatever java file, run javac <filename>.java to compile (within directory, obv)
- Then run java <filename> to run the program.
- Nice, but rather do it through the IDE. Settled on Eclipse at least for now.

[Getting Eclipse to run Java](https://help.eclipse.org/luna/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Ftasks%2Ftasks-java-local-configuration.htm)

I had a file that I made with sublime text to start, but bringing it into Ecliipse caused issues with the run configuration. As is, it needs to be built manually (With the Run -> Run Configuration option). Bouncing between files might be tricky, but this should work just fine.

## Chapter 3: ~ Building Blocks

- **Java is case sensitive.** White space is, however, not enforced.
- Java compiles into bytecode, but the resulting .class file can’t be read normally (wordpad and the like) without an additional library. Book uses Ando Saabas’ Bytecode Editor.
- This compilation plays into why Jave rules. It is usable by any system because the system does the interpretation.
- [Help deciphering documentation](www.allmycode.com/JavaForDummies)

**3 Types of ‘words’ in Java:**
1. Keywords: reserved words, mean the same thing across all Java programs. if, else and do.
2. Identifiers: The names we create for variables and such.
3. Identifiers from the API: Java has an API which seems to be like a core supported collection of libraries. It lists String and Integer as examples here, so it may be more baked in than that.

Goes on to define methods in Java, nothing surprising here.

The main of `public static void main(String args[])` is a special kind of method that does not need to be invoked. It is called into action automatically when the program begins running.

System.out.println is an example of a method coming from the API.

Javadoc comments can be used to generate a write-up of the class. Beyond that commenting is routine.

