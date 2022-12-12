package dani.kotlin.template.basicrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import dani.kotlin.template.basicrecycler.adapter.BasicAdapter
import dani.kotlin.template.basicrecycler.data.RetrofitService
import dani.kotlin.template.basicrecycler.databinding.ActivityMainBinding
import dani.kotlin.template.basicrecycler.model.BasicModel
import dani.kotlin.template.basicrecycler.model.BasicModelData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        var employeeList = MutableLiveData<List<BasicModelData>>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = BasicAdapter(emptyList())
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(baseContext)
            this.adapter  = adapter
        }

        RetrofitService.getEmployees()
        employeeList.observe(this) {
            adapter.items = it
            adapter.notifyItemRangeChanged(0, it.size)
        }
    }
}