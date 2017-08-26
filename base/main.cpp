#define _WIN32_WINNT 0x500

#include <iostream>
#include <cstdlib>
#include <fstream>
#include <windows.h>

using namespace std;

int main()
{

    ShowWindow(GetConsoleWindow(), 0);

    string dir, command;
    fstream file;

    system("@cd > dir.l");

    file.open("dir.l", ios::in);
    getline(file, dir);
    command = "java -jar -Dfile.encoding=UTF-8 C:\\base\\tdc.jar \""+dir+"\"";
    file.close();

    system("@del dir.l");
    system(command.c_str());

    return 0;
}
