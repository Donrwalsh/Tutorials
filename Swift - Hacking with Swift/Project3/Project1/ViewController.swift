//
//  ViewController.swift
//  Project1
//
//  Created by Don Walsh on 6/26/17.
//  Copyright © 2017 Don Walsh. All rights reserved.
//

import UIKit
//this file will reference the iOS user interface toolkit

class ViewController: UITableViewController {
//I want to create a new screen of data called ViewController, based on UITableViewController

// UIViewController is Apples's default screen type, which is empty and white until we change it.
    
// UITableViewController is based on UIViewController but adds the ability to show rows of data that can be scrolled and selected.
    
    var pictures = [String]()
    //Creating an array of strings within the ViewController, available for as long as the screen exists

    override func viewDidLoad() {
    //override indicates we want to change Apple's default behavior from UIView Controller.
    //viewDidLoad() is called when the screen has loaded and is ready to be customized.
        
        super.viewDidLoad()
        // super means "Tell Apple's UIViewController to run its own code before I run mine".
        
        title = "Storm Viewer"
        
        let fm = FileManager.default
        //Declares a constant that lets us work in the filesystem and look for files.
        let path = Bundle.main.resourcePath!
        //Declares a constant path that is set to the main resource path of the app's bundle.
        let items = try! fm.contentsOfDirectory(atPath: path)
        //Declares a constant that is an array of filenames in the path of our app's bundle.
        
        for item in items {
            if item.hasPrefix("nssl") { //All the example images begin with 'nssl'
                pictures.append(item)
            }
        }
        print(pictures)
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
    //overriding the function tableView, informing it that it is for the tableView UITableView.
    //The next piece is the method describing what we're setting the numberOfRowsInSection to pictures.count
        return pictures.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
    //Calling cellForRowAt method which must return a table view cell. (Created in the interface builder)
        let cell = tableView.dequeueReusableCell(withIdentifier: "Picture", for: indexPath)
        //iOS treats cells in a table view as rotating. This^ line dequeues a recycled cell from the table.
        cell.textLabel?.text = pictures[indexPath.row]
        //The ? means do this only if there is an actual text label there, do nothing otherwise.
        return cell
    }

    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        // 1: try loading the "Detail" view controller and typecasting it to be DetailViewController
        if let vc = storyboard?.instantiateViewController(withIdentifier: "Detail") as? DetailViewController {
            // 2: success! Set its selectedImage property
            vc.selectedImage = pictures[indexPath.row]
            
            // 3: now push it onto the navigation controller
            navigationController?.pushViewController(vc, animated: true)
        }
    }
    
    override func didReceiveMemoryWarning() {
    //Overriding default behavior, this time when the system is running low on resources.
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

