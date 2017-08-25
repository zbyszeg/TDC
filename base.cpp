#define _WIN32_WINNT 0x500

#include <iostream>
#include <cstdlib>
#include <fstream>
#include <windows.h>

using namespace std;

int main(int argc, char* argv[])
{

    ShowWindow(GetConsoleWindow(), 0);

    string name, line, command;
    fstream file;

    name = argv[1];

    system("@cd > dir.txt");

    file.open("dir.txt", ios::in);
    getline(file, line);
    command = "java -jar -Dfile.encoding=UTF-8 C:\\base\\tdc.jar \""+line+"\\"+name+"\"";
    file.close();

    system("@del dir.txt");
    system(command.c_str());

    return 0;
}
