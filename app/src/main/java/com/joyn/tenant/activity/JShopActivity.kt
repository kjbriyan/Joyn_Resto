package com.joyn.tenant.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
import com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.joyn.tenant.R
import com.joyn.tenant.utils.Helper
import kotlinx.android.synthetic.main.bottom_sheet_set_destination.*
import kotlinx.android.synthetic.main.bottom_sheet_shop_location.*

class JShopActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var bottomSheetDestintaion: BottomSheetBehavior<*>
    private lateinit var bottomSheetLocation: BottomSheetBehavior<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jshop)
        val mapFragment: SupportMapFragment? =
            supportFragmentManager.findFragmentById(R.id.container_map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
        btn_set_destination.clearFocus()
        initBottomSheetDestination()
    }

    private fun initBottomSheetDestination() {
        bottomSheetDestintaion = BottomSheetBehavior.from(bottom_sheet_layout)
        bottomSheetDestintaion.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        hideKeyboard()
                        initBottomSheetLocation()
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        btn_set_destination.visibility = View.VISIBLE
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        btn_set_destination.visibility = View.GONE
                        input_places.clearFocus()
                        hideKeyboard()
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        btn_set_destination.visibility = View.GONE
                    }
                }
            }
        })

        input_places.onFocusChangeListener = object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {

                if (hasFocus) {
                    bottomSheetDestintaion.state = BottomSheetBehavior.STATE_EXPANDED
                    Log.d("Focus", "focus $hasFocus")
                } else {
                    Log.d("Focus", "focus $hasFocus")
                }
            }
        }
        btn_set_destination.setOnClickListener {
            bottomSheetDestintaion.isHideable = true
            bottomSheetDestintaion.state = BottomSheetBehavior.STATE_HIDDEN
        }
    }

    private fun initBottomSheetLocation() {
        bottomSheetLocation = BottomSheetBehavior.from(bottom_sheet_shop_location)
        bottomSheetLocation.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheetLocation.peekHeight = BottomSheetBehavior.PEEK_HEIGHT_AUTO
        bottomSheetLocation.isHideable = false

        mMap.setOnCameraMoveStartedListener(object : OnCameraMoveStartedListener {
            override fun onCameraMoveStarted(reason: Int) {
                if (reason == OnCameraMoveStartedListener.REASON_GESTURE) {
                    Log.d("Moving", "Gesture $reason")
                }
            }
        })

        mMap.setOnCameraIdleListener(object : OnCameraIdleListener {
            override fun onCameraIdle() {
                Log.d("Moving", "On IDLE")
            }
        })

        btn_to_order.setOnClickListener { Helper().moveActivity(this, OrderActivity::class.java) }
    }

    override fun onMapReady(map: GoogleMap) {
        mMap = map
        mMap.isMyLocationEnabled = true
        val latLang =
            LatLng(mMap.cameraPosition.target.latitude, mMap.cameraPosition.target.longitude)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLang, 13f))

    }

    private fun hideKeyboard() {
        val imm =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(input_places.windowToken, 0)
    }

    override fun onBackPressed() {

        if (bottomSheetLocation.state == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetLocation.isHideable = true
            bottomSheetLocation.state = BottomSheetBehavior.STATE_HIDDEN
            bottomSheetDestintaion.state = BottomSheetBehavior.STATE_COLLAPSED
            bottomSheetDestintaion.isHideable = false
            return
        }
        super.onBackPressed()
    }
}
