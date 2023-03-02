package com.innovation.tramo.clientLauncher.ui.slideshow

//import com.innovation.tramo.clientLauncher.databinding.FragmentSlideshowBinding
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.innovation.tramo.R
import com.innovation.tramo.clientLauncher.Settings.ActivitySettingsCliente
import com.innovation.tramo.databinding.FragmentSlideshowBinding
import com.innovation.tramo.logIn.ActivityLogInClient
import com.innovation.tramo.clientLauncher.ui.slideshow.SlideshowFragment as SlideshowFragment
import com.innovation.tramo.clientLauncher.ui.slideshow.SlideshowViewModel as SlideshowViewModel1

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel1::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }


        binding.IrAcercaApp.setOnClickListener{
            goIrCliente()
        }
        binding.IrLoginClient.setOnClickListener{
            goIrClientLogin()
        }

        return root
    }

    private fun goIrClientLogin() {
        val intent = Intent(activity, ActivityLogInClient::class.java)
        startActivity(intent)
    }

    private fun goIrCliente() {
        val intent = Intent(activity, ActivitySettingsCliente::class.java)
        startActivity(intent)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}