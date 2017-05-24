//
//  Meal.swift
//  FoodTracker
//
//  Created by Laura Farvour on 5/24/17.
//  Copyright © 2017 Bigbrass. All rights reserved.
//

import UIKit

class Meal {
    
    //MARK: Properties
    
    var name: String
    var photo: UIImage?
    var rating: Int
    
    //MARK: Initialization

    
    
    //Prepares instance of a class for use, sets an initial value for each property and other setup or initializations
    
    init?(name: String, photo: UIImage?, rating: Int) {
        // The name must not be empty
        guard !name.isEmpty else {
            return nil
        }
        
        // The rating must be between - and 5 inclusively
        guard (rating >= 0) && (rating <= 5) else {
            return nil
        }
        
        // Initialize stored properties.
        self.name = name
        self.photo = photo
        self.rating = rating
    }
}

