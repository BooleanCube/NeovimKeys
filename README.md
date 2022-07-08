# NeovimKeys
> Practice Using Neovim and Moving around with the Keys HJKL.

Using NeovimKeys for 10-20 minutes before using Neovim always helps. With enough practice every day, you should be able to use HJKL in neovim like a pro and be a lot more productive.

This project is a work in progress and I will add a section to update your keybindings and also add more macros for you to be able to entirely simulate productive use of neovim/vim.

### Download Instructions:
1) Download [Java](https://www.java.com/en/download/manual.jsp) to be able to run the `.jar` file.
2) Go to the [Releases Page](https://github.com/BooleanCube/NeovimKeys/releases)
3) Download the `.jar` file from the latest release
4) You can drag and drop it from the Downloads folder to your Desktop (or store it anywhere on your PC, the Desktop is just for easy access)
5) To run the application, you can simply just double click the icon with `NeovimKeys.jar`
(if you are on Windows 10 it will give you a prompt asking how you want to run the application like below. Just select the first one that says `Java` and click `ok`) <br>
![image](https://user-images.githubusercontent.com/47650058/147600218-5d859509-a573-4766-8541-5598bcd001ab.png)
6) It can also be run through the command line like this: `java -jar /path/to/jar/NeovimKeys.jar`

### Building Jar Instructions:
1) Download the source code as a ZIP file and extract it into a folder.
2) Go into the project directory and then cd into the `out/production/NeovimKeys/` directory to see all the compiled classes.
3) In the terminal, type the following command to build the jar file by yourself:<br>
`jar -cvfm ../../artifacts/NeovimKeys.jar META-INF/MANIFEST.MF Frame.class Node.class style.class`
4) The jar file will then build to `out/artifacts/` and can be easily ran by running the command:<br>`java -jar path/to/jar/NeovimKeys.jar`

## Controls
This works like how any ordinary Neovim would work. <br>
In `Normal` Mode (when the cursor is black), to move you use `HJKL` (H = left, J = down, K = up, L = right) <br>
In `Insert` Mode (when your cursor is green), you can type text and use `arrow keys` to move. <br>
The goal is to move to the blue node with text in the center and type whatever is in the node. After you do that, the blue node will reposition with new text. This will go in an endless cycle and you can practice until you feel fast.

![ezclap](https://user-images.githubusercontent.com/47650058/147601719-d6d4bda3-2fd7-46a3-851a-7e62726851ef.gif)

**CURSOR (Normal Mode)**: <br>
![image](https://user-images.githubusercontent.com/47650058/147601959-fb17058e-be76-4d23-932a-7ffd5f5c228a.png)

**CURSOR (Insert Mode)**: <br>
![image](https://user-images.githubusercontent.com/47650058/147601977-be869d02-a7e8-4520-aca0-4bf1d9ec79ef.png)

**GOAL**: <br>
![image](https://user-images.githubusercontent.com/47650058/147601942-5b458039-b80a-4402-b0f8-4e959b0a6521.png)

**IDICATORS**: <br>
![image](https://user-images.githubusercontent.com/47650058/152663451-de18fcee-c74f-4c9a-bbd0-58cee10cde62.png)

*a project by BooleanCube :]*
