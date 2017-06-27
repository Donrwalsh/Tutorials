//
//  DetailViewController.swift
//  Project1
//
//  Created by Don Walsh on 6/26/17.
//  Copyright © 2017 Don Walsh. All rights reserved.
//

import UIKit
import Social

class DetailViewController: UIViewController {
    @IBOutlet weak var ImageView: UIImageView!
    //This was dragged from the storyboard in assistant view
    
    var selectedImage: String?

    override func viewDidLoad() {
        super.viewDidLoad()

        title = selectedImage
        
        navigationItem.rightBarButtonItem = UIBarButtonItem(barButtonSystemItem: .action, target: self, action: #selector(shareTapped))
        
        // Do any additional setup after loading the view.
        if let imageToLoad = selectedImage {
            ImageView.image = UIImage(named: imageToLoad)
        }
        
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        navigationController?.hidesBarsOnTap = true
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        navigationController?.hidesBarsOnTap = false
    }
    
    func shareTapped() {
        // General Sharing code:
        let vc = UIActivityViewController(activityItems: [ImageView.image!], applicationActivities: [])
        vc.popoverPresentationController?.barButtonItem = navigationItem.rightBarButtonItem
        present(vc, animated: true)
        // Facebook specific sharing code:
        //if let vc = SLComposeViewController(forServiceType: SLServiceTypeFacebook) {
        //    vc.setInitialText("Look at this great picture!")
        //    vc.add(ImageView.image!)
        //    vc.add(URL(string: "http://www.photolib.noaa.gov/nssl"))
        //    present(vc, animated: true)
        //For twitter, change SlServiceTypeTwitter
        //}
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
