using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class PlayerController : MonoBehaviour 
{

	// Using same speed reference in both, desktop and other devices
	public float speed;

	public Text countText;
	public Text winText;

	private Rigidbody rb;
	private int count;	

	void Start ()
	{
		rb = GetComponent<Rigidbody> ();
		count = 0;
		SetCountText ();
		winText.text = "";
	}

	void Main ()
	{
		// Preventing mobile devices going in to sleep mode 
		//(actual problem if only accelerometer input is used)
		Screen.sleepTimeout = SleepTimeout.NeverSleep;
		Screen.orientation = ScreenOrientation.LandscapeLeft;
	}



	void Update()
	{

		if (SystemInfo.deviceType == DeviceType.Desktop) 
		{
			// Exit condition for Desktop devices
			if (Input.GetKey("escape"))
				Application.Quit();
		}
		else
		{
			// Exit condition for mobile devices
			if (Input.GetKeyDown(KeyCode.Escape))
				Application.Quit();            
		}



	}


	void FixedUpdate ()
	{
		if (SystemInfo.deviceType == DeviceType.Desktop) 
		{ 
			// Player movement in desktop devices
			// Definition of force vector X and Y components
			float moveHorizontal = Input.GetAxis("Horizontal");
			float moveVertical = Input.GetAxis("Vertical");
			// Building of force vector
			Vector3 movement = new Vector3 (moveHorizontal,0.0f,moveVertical);
			// Adding force to rigidbody
			rb.AddForce(movement * speed * Time.deltaTime);
		}
		else
		{
			// Player movement in mobile devices
			// Building of force vecto	r 
			Vector3 movement = new Vector3 (Input.acceleration.x, 0.0f, Input.acceleration.y);
			// Adding force to rigidbody
			rb.AddForce(movement * speed * Time.deltaTime);
		}


	}

	void OnTriggerEnter(Collider other) 
	{

		if (other.gameObject.CompareTag ("Pickup")) 
		{
			other.gameObject.SetActive (false);
			count = count + 1;
			SetCountText ();
		}
	}

	void SetCountText ()
	{
		countText.text = "Count: " + count.ToString ();
		if (count >= 12) 
		{
			winText.text = "You Win!";
		}

	}


}