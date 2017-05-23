//
//  ViewController.swift
//  FoodTracker
//
//  Created by Laura Farvour on 5/23/17.
//  Copyright © 2017 Bigbrass. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    //Adopts the UITextFieldDelegate protocol. Tells the compiler that the ViewController class can act as a valid text field delegate.
    
    //MARK: Properties
    @IBOutlet weak var nameTextField: UITextField!
    @IBOutlet weak var mealNameLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Handle the text field's user input through delegate callbacks.
        nameTextField.delegate = self
    }

    //Mark: UITextFieldDelegate
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        // Hide the keyboard (ends first responder status when the user is done typing)
        textField.resignFirstResponder()
        return true
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        mealNameLabel.text = textField.text
    }
    
    //MARK: Actions
    @IBAction func setDefaultLabelText(_ sender: UIButton) {
        mealNameLabel.text = "Default Text"
    }

}

