package com.example.kotlin.ui.navigationfragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.kotlin.R
import com.example.kotlin.ui.model.User

/**
 * A simple [Fragment] subclass.
 */
class NotificationDetailsFragment : Fragment() {

    private lateinit var userModel: User
    lateinit var recipient: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification_details, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments!!.getString("sendValue")!!
        userModel = arguments!!.getParcelable("sendModel")!!

//        val safeArgs: NotificationsFragmentArgs by navArgs()
       /* Log.e("Nive ", "onCreate:NotificaitonDetails " + safeArgs.sendValue)
        Log.e("Nive ", "onCreate:NotificaitonDetails sendModel " + safeArgs.sendModel)
*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onAttach(context: Context) {
        (activity as NavActivity).hideBottomNavigation()
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        (activity as NavActivity).showBottomNavigation()
    }

}
