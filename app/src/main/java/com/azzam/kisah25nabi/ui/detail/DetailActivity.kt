package com.azzam.kisah25nabi.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azzam.kisah25nabi.data.KisahResponse
import com.azzam.kisah25nabi.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<KisahResponse>(EXTRA_DATA)
        data?.let {
            binding.apply {
                Glide.with(this@DetailActivity)
                    .load(data?.imageUrl)
                    .into(detailImage)
                detailNama.text = data.name
                detailTempat.text = data.tmp
                detailUsia.text = data.usia
                detailDesk.text = data.description
            }
        }

    }

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"
    }
}