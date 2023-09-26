package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.content.Context
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

//import com.google.firebase.database.DatabaseReference
//import android.content.res.Configuration
//import android.widget.Toast
//import androidx.appcompat.app.ActionBarDrawerToggle
//import androidx.drawerlayout.widget.DrawerLayout
//import com.google.android.material.navigation.NavigationView
//import android.util.Log
//import java.util.Locale
//import android.view.MenuItem
//import androidx.appcompat.app.AppCompatActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */


class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
//    lateinit var toggle: ActionBarDrawerToggle

//    private lateinit var drawerLayout: DrawerLayout
//    private lateinit var navView: NavigationView
//    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        val intent = Intent(requireActivity(), homeActivity::class.java)
        requireActivity().startActivity(intent)

    }

    private lateinit var GoToRent: Button
    private lateinit var GoToAgro: Button
    private lateinit var GoToDisease: Button
    private lateinit var GoToOutbreaks: Button
    private lateinit var btnGoToKN: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize buttons here using findViewById
        GoToRent = view.findViewById(R.id.GoToRent)
        GoToAgro = view.findViewById(R.id.GoToAgro)
        GoToDisease = view.findViewById(R.id.GoToDisease)
        GoToOutbreaks = view.findViewById(R.id.GoToOutbreaks)
        btnGoToKN = view.findViewById(R.id.btnGoToKN)

        // Now you can set click listeners or perform other actions with these buttons
        GoToRent.setOnClickListener {
            val intent = Intent(requireActivity(), RentActivity::class.java)
            intent.putExtra("key_name", "Hello from MainActivity!")
            startActivity(intent)
        }

        GoToAgro.setOnClickListener{
            val intent = Intent(requireActivity(), agrotourismActivity::class.java)
            intent.putExtra("key_name", "Hello from MainActivity!")
            startActivity(intent)
        }

        fun RedirectHome(view: View){
            val intent = Intent(requireActivity(), Home::class.java)
            intent.putExtra("key_name", "Hello from MainActivity!")
            startActivity(intent)
        }
        GoToDisease.setOnClickListener{
            val intent = Intent(requireActivity(), detectionActivity::class.java)
            intent.putExtra("key_name", "Hello from MainActivity!")
            startActivity(intent)
        }
        GoToOutbreaks.setOnClickListener{
            val intent = Intent(requireActivity(), OutBreaksActivity::class.java)
            intent.putExtra("key_name", "Hello from MainActivity!")
            startActivity(intent)
        }
        fun Redirectsignuppage(view: View){
            val intent = Intent(requireActivity(), signUpActivity::class.java)
            intent.putExtra("key_name", "Hello from MainActivity!")
            startActivity(intent)
        }
        btnGoToKN.setOnClickListener{
            val intent = Intent(requireActivity(), mpsellActivity::class.java)
            intent.putExtra("key_name", "Hello from MainActivity!")
            startActivity(intent)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize UI elements from the fragment's layout
        val btnKnowMoreMicroFin: Button = view.findViewById(R.id.btnKnowMoreMicroFin)
        val btnKnowMoreRent: Button = view.findViewById(R.id.btnKnowMoreRent)

        // Set click listeners for buttons
        btnKnowMoreMicroFin.setOnClickListener {
            val FName: String? = "MICRO FINANCE"
            val FExplain: String? = "Here Farmers can do Stock level shit (Baadme Explain karna)"
            showCustomDialogBox1(FName, FExplain)
        }

        btnKnowMoreRent.setOnClickListener {
            val FName: String? = "Rental Platform"
            val FExplain: String? = "Farmers can Rent out as well as Take others items on Rent"
            showCustomDialogBox1(FName, FExplain)
        }

        //QUESTION ASKING BUTTONS

        val btnGoTOKN: Button = view.findViewById(R.id.btnGoToKN)

        btnGoTOKN.setOnClickListener {
            val Question:String?="DO YOU WANT INVESTMENT OR WANT TO INVEST?"

            showCustomDialogBox2(Question)
        }

        val btnGoToMP: Button = view.findViewById(R.id.btnGoToMP)

        btnGoToMP.setOnClickListener {
            val Question:String?="Who Are You ?"

            showCustomDialogBox3(Question)
        }
//        drawerLayout = findViewById(R.id.drawer)
//        navView= findViewById(R.id.nav_view)
//        toggle= ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()

//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        navView.setNavigationItemSelectedListener {
//            Log.d("Ghusa","ha")
//            when(it.itemId){
//                R.id.Setting -> {
//                    Log.d("MenuItemClick", "Setting menu item clicked")
//                    Toast.makeText(this, "Clickkk", Toast.LENGTH_SHORT).show()
//                }
//                R.id.ChangeLang ->{
//                    RedirectHome(navView)
//                }
//                R.id.LOGOUT ->{
//                    Redirectsignuppage(navView)
//                }
//            }
//            true
//        }

        return view
    }

//    fun getCurrentLocaleLanguage(context: Context): String {
//        val resources = context.resources
//        val configuration: Configuration = resources.configuration
//        val locale: Locale = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//            configuration.locales[0]
//        } else {
//            configuration.locale
//        }
//        return locale.language // Returns the current language code (e.g., "en" for English)
//    }
    private fun showCustomDialogBox1(FName: String?,FExplain:String?) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_know_more)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val FeatureName : TextView =dialog.findViewById(R.id.FeatureName)
        val FeatureExplain : TextView =dialog.findViewById(R.id.FeatureExplain)
        val btnBackKM : Button = dialog.findViewById(R.id.btnBackKM)

        FeatureName.text=FName
        FeatureExplain.text=FExplain

        btnBackKM.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()

    }

    private fun showCustomDialogBox2(Ques: String?) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_layout_ques)

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val Question : TextView =dialog.findViewById(R.id.question)
        val opt_1 : Button = dialog.findViewById(R.id.opt_1)
        val opt_2 : Button = dialog.findViewById(R.id.opt_2)

        Question.text=Ques

        opt_1.setOnClickListener {
            val sharedPref = requireContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
            val savedUserName = sharedPref.getString("User", "def") ?: "."
            val database = FirebaseDatabase.getInstance().getReference("VerifiedFarmers")
            var allow = false

// Use a ValueEventListener to check if savedUserName exists in VerifiedFarmers
            database.child(savedUserName).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        allow = true
                    }

                    // Now that we have determined whether the user exists in VerifiedFarmers,
                    // you can start the appropriate activity here.
                    if (allow) {
                        startActivity(Intent(requireActivity(), microfinancesActivity::class.java))
                    } else {
                        startActivity(Intent(requireActivity(), verifylockActivity::class.java))
                    }
                    dialog.dismiss()
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Handle any errors or cancellations here if needed.
                    // You can set allow to false in case of errors.
                    allow = false
                    dialog.dismiss()
                }
            })
        }
        opt_2.setOnClickListener {

            dialog.dismiss()
        }

        dialog.show()

    }
    private fun showCustomDialogBox3(Ques: String?) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_layout_ques)

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val Question : TextView =dialog.findViewById(R.id.question)
        val opt_1 : Button = dialog.findViewById(R.id.opt_1)
        val opt_2 : Button = dialog.findViewById(R.id.opt_2)

        Question.text=Ques

        opt_1.setOnClickListener {

            startActivity(Intent(requireActivity(), mpsellActivity::class.java))
            dialog.dismiss()
        }
        opt_2.setOnClickListener {

            dialog.dismiss()
        }

        dialog.show()

    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(toggle.onOptionsItemSelected(item)) return true
//        return super.onOptionsItemSelected(item)
//    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}