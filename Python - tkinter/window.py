#!/usr/bin/python
# -*- coding: utf-8 -*-
import tkinter as tk

LARGE_FONT = ("Verdana", 12)

class wifiAnalyzer(tk.Tk):

    #this method will be run on app startup
    def __init__(self, *args, **kwargs):

        tk.Tk.__init__(self) #Let's also initiate tkinter
        container = tk.Frame(self) #Essentially a 'window' in the form of a frame.

        # Two types of formatting for tkinter apps, pack and grid:
        # Pack: Dropping elements into a big, you can kinda tell them where to go but not complete control
        # Grid: More control for specifying the position of elements in the frame.

        #In the frame, starting from the top, we're going to fill the entire space specified by the frame. Expand allows to go beyond the limits set by the frame.
        container.pack(side="top", fill="both", expand = True)

        # 0 is the minimum size, weight specifies the priority of the rule
        container.grid_rowconfigure(0, weight=1)
        container.grid_columnconfigure(0, weight=1)

        self.frames = {} #initialize a dictionary to organize our frames

        for F in (StartPage, PageOne, PageTwo):
            frame = F(container, self)

            self.frames[F] = frame

            frame.grid(row=0, column=0, sticky="nsew")

        self.show_frame(StartPage)

    def show_frame(self, cont): #where cont is a key of the frames dictionary
        #Bring a specified frame to the 'front' of the application

        frame = self.frames[cont]
        frame.tkraise()

class StartPage(tk.Frame):

    def __init__(self, parent, controller):
        tk.Frame.__init__(self,parent)
        label = tk.Label(self, text="Start Page", font=LARGE_FONT) #Basic syntax idea, here we have made an object
        label.pack(pady=10, padx=10)                               #and this will display the object we created, with params

        button1 = tk.Button(self, text="Visit Page 1", command=lambda:controller.show_frame(PageOne))
        button1.pack()

        button2 = tk.Button(self, text="Visit Page 2", command=lambda: controller.show_frame(PageTwo))
        button2.pack()

class PageOne(tk.Frame):

    def __init__(self, parent, controller):
        tk.Frame.__init__(self, parent)
        label = tk.Label(self, text="Page One", font=LARGE_FONT)
        label.pack(pady=10, padx=10)

        button1 = tk.Button(self, text="Back to Home", command=lambda: controller.show_frame(StartPage))
        button1.pack()

        button2 = tk.Button(self, text="Visit Page 2", command=lambda: controller.show_frame(PageTwo))
        button2.pack()

class PageTwo(tk.Frame):

    def __init__(self, parent, controller):
        tk.Frame.__init__(self, parent)
        label = tk.Label(self, text="Page Two", font=LARGE_FONT)
        label.pack(pady=10, padx=10)

        button1 = tk.Button(self, text="Back to Home", command=lambda: controller.show_frame(StartPage))
        button1.pack()

        button2 = tk.Button(self, text="Page One", command=lambda: controller.show_frame(PageOne))
        button2.pack()

app = wifiAnalyzer()
app.mainloop()