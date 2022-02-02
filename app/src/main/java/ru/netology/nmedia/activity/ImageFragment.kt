package ru.netology.nmedia.activity

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.net.toFile
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.github.dhaval2404.imagepicker.ImagePicker
import com.github.dhaval2404.imagepicker.constant.ImageProvider
import com.google.android.material.snackbar.Snackbar
import ru.netology.nmedia.R
import ru.netology.nmedia.activity.NewPostFragment.Companion.textArg
import ru.netology.nmedia.adapter.OnInteractionListener
import ru.netology.nmedia.adapter.PostsAdapter
import ru.netology.nmedia.databinding.FragmentFeedBinding
import ru.netology.nmedia.databinding.FragmentImageBinding
import ru.netology.nmedia.databinding.FragmentNewPostBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.util.AndroidUtils
import ru.netology.nmedia.util.StringArg
import ru.netology.nmedia.view.load
import ru.netology.nmedia.viewmodel.PostViewModel

class ImageFragment : Fragment() {

//    override fun onStart() {
//        super.onStart()
//
//        (activity as AppCompatActivity).supportActionBar!!.hide()
//    }
    private var fragmentBinding: FragmentImageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentImageBinding.inflate(inflater, container, false)

        val activity = requireActivity()
        if (activity is AppCompatActivity) {
            val statusBarColor = ContextCompat.getColor(requireActivity(), R.color.black)
            activity.window.statusBarColor = statusBarColor
            activity.supportActionBar?.setBackgroundDrawable(ColorDrawable(statusBarColor))
        }
        val url = "http://10.0.2.2:9999/media/${arguments?.getString("url")}"
//
//        fragmentBinding = binding
//
//        arguments?.urlArg
//            ?.let(binding.attachmentImage::load)
        Glide.with(this)
            .load(url)
            .into(binding.attachmentImage)


        return binding.root
    }


    override fun onDestroyView() {
        // fragmentBinding = null
        super.onDestroyView()
        val activity = requireActivity()
        if (activity is AppCompatActivity) {
            val statusBarColor = ContextCompat.getColor(
                requireActivity(),
                R.color.design_default_color_primary_variant
            )
            activity.window.statusBarColor = statusBarColor
            activity.supportActionBar?.setBackgroundDrawable(ColorDrawable(statusBarColor))
        }
    }
}
