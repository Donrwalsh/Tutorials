//
//  FoodTrackerTests.swift
//  FoodTrackerTests
//
//  Created by Laura Farvour on 5/23/17.
//  Copyright © 2017 Bigbrass. All rights reserved.
//


import XCTest
@testable import FoodTracker

class FoodTrackerUITests: XCTestCase {
    
    //MARK: Meal Class Tests
    
    //Confirm that the Meal initializer returns a Meal object when passed valid parameters.
    func testMealInitializationSucceeds() {
        //Negative rating
        let negativeRatingMeal = Meal.init(name: "Negative", photo: nil, rating: -1)
        XCTAssertNil(negativeRatingMeal)
        
        //Rating exceeds maximum
        let largeRatingMeal = Meal.init(name: "Large", photo: nil, rating: 6)
        XCTAssertNil(largeRatingMeal)
        
        //Empty String
        let emptyStringMeal = Meal.init(name: "", photo: nil, rating: 0)
        XCTAssertNil(emptyStringMeal)
    }
}
