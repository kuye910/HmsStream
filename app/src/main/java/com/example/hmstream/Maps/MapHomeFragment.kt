package com.example.hmstream.Maps

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hmstream.databinding.FragmentMapHomeBinding
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.OnMapReadyCallback

class MapHomeFragment : Fragment(), OnMapReadyCallback {

    private lateinit var binding: FragmentMapHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMapHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    private val TAG = "hmsMaps"
    private var mapViewBundle: Bundle? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle("MapViewBundleKey")
        }
        binding.hmsMapView.onCreate(mapViewBundle)
        binding.hmsMapView.getMapAsync(this)

    }

    override fun onMapReady(huaweiMap: HuaweiMap?) {
        Log.e(TAG, "onMapReady: ")
        if (huaweiMap != null) {
            huaweiMap.mapType=HuaweiMap.MAP_TYPE_NORMAL
            huaweiMap.isMyLocationEnabled=true
            huaweiMap.uiSettings.isMyLocationButtonEnabled=true
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding.hmsMapView.onDestroy()
    }


}