package com.example.kotlin.ui.navigationfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.kotlin.R
import com.example.kotlin.ui.model.User
import kotlinx.android.synthetic.main.fragment_notifications.*


/**
 * A simple [Fragment] subclass.
 */
class NotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    fun setupViews() {

        var actionUser: User =
            User()
        actionUser.id = "1"
        actionUser.name = "Nive"


        val bundle = bundleOf(
            "sendValue" to btnNotificationDetails.text.toString(),
            "sendModel" to actionUser
        )

        /* val value =
             NotificationsFragmentDirections.actionNotificationsFragmentToNotificationDetailsFragment(
                 arg1=btnNotificationDetails.text.toString(),
                 actionUser
             )*/


        btnNotificationDetails.setOnClickListener {

            findNavController(requireParentFragment()).navigate(
                R.id.action_notificationsFragment_to_notificationDetailsFragment,
                bundle
            )
        }
    }

}
