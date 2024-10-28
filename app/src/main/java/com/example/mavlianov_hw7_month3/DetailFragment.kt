package com.example.mavlianov_hw7_month3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mavlianov_hw7_month3.databinding.FragmentDetailBinding
import java.io.Serializable


@Suppress("DEPRECATION")
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val car = args.Car
            textViewBrand.text = car.brand
            textViewCost.text = car.cost
            textViewDesc.text = car.desc
            Glide.with(imageView).load(car.image).into(imageView)

            buttonCall.setOnClickListener {
                val callIntent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${car.phoneNumber}")
                }
                startActivity(callIntent)
            }

            buttonWhatsApp.setOnClickListener {
                val whatsappIntent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://api.whatsapp.com/send?phone=${car.phoneNumber}")
                }
                startActivity(whatsappIntent)
            }
        }
    }
}