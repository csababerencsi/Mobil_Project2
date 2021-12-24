package hu.inf.unideb.projekt2.feature.city

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import hu.inf.unideb.projekt2.databinding.ActivityCityBinding
import hu.inf.unideb.projekt2.feature.details.DetailsActivity

class CityActivity : AppCompatActivity(), CityAdapter.OnCitySelectedListener,
    AddCityDialogFragment.AddCityDialogListener {

    private lateinit var binding: ActivityCityBinding
    private lateinit var adapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFab()
        initRecyclerView()
    }

    private fun initFab() {
        binding.fab.setOnClickListener {
            AddCityDialogFragment().show(supportFragmentManager, AddCityDialogFragment::class.java.simpleName)
            /*adapter.addCity("Budapest")
            adapter.addCity("Debrecen")
            adapter.addCity("Sopron")
            adapter.addCity("Szeged")*/
        }
    }


    private fun initRecyclerView() {
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CityAdapter(this)
        adapter.addCity("Budapest")
        adapter.addCity("Debrecen")
        adapter.addCity("Sopron")
        adapter.addCity("Szeged")
        binding.mainRecyclerView.adapter = adapter
    }

    override fun onCitySelected(city: String?) {
        val showDetailsIntent = Intent()
        showDetailsIntent.setClass(this@CityActivity, DetailsActivity::class.java)
        showDetailsIntent.putExtra(DetailsActivity.EXTRA_CITY_NAME, city)
        startActivity(showDetailsIntent)
    }

    override fun onCityDeleted(position: Int){
        adapter.removeCity(position)
    }


    override fun onCityAdded(city: String?) {
        adapter.addCity(city!!)
    }
}
