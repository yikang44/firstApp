package com.example.weather

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.ItemizedIconOverlay
import org.osmdroid.views.overlay.OverlayItem
import java.util.ArrayList

class MapActivity : AppCompatActivity() {
    private lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val action = supportActionBar
        action?.title = getString(R.string.map)
        Configuration.getInstance().load(applicationContext, PreferenceManager.getDefaultSharedPreferences(applicationContext))

        mapView = findViewById(R.id.mapView)
        mapView.setTileSource(TileSourceFactory.MAPNIK)

        val mapController = mapView.controller
        mapController.setZoom(15.0)
        val startPoint = GeoPoint(48.8583, 2.2944)
        mapController.setCenter(startPoint)

        val items = ArrayList<OverlayItem>()

        val icon : Drawable = resources.getDrawable(R.drawable.baseline_location)


        val locationOverlayItem = OverlayItem("Location", "This is location", GeoPoint(25.0330, 121.5654))
        locationOverlayItem.setMarker(icon)
        items.add(locationOverlayItem)

        val locationOverlayItem1 = OverlayItem("Location", "This is location1", GeoPoint(48.8583, 2.2944))
        locationOverlayItem1.setMarker(icon)
        items.add(locationOverlayItem1)

        val locationOverlayItem2 = OverlayItem("Location", "This is location2", GeoPoint(40.7128, 74.0060))
        locationOverlayItem2.setMarker(icon)
        items.add(locationOverlayItem2)

        val overlay = ItemizedIconOverlay(items, null, applicationContext)
        mapView.overlays.add(overlay)


    }

    override fun onResume(){
        super.onResume()
        mapView.onResume()
    }

    override fun onPause(){
        super.onPause()
        mapView.onResume()
    }

}