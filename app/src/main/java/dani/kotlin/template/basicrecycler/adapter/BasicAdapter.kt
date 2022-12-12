package dani.kotlin.template.basicrecycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import dani.kotlin.template.basicrecycler.R
import dani.kotlin.template.basicrecycler.databinding.RecyclerItemBinding
import dani.kotlin.template.basicrecycler.model.BasicModelData

class BasicAdapter(
    var items: List<BasicModelData>
) : RecyclerView.Adapter<BasicAdapter.BasicViewHolder>()
{
    override fun getItemCount() = items.size

    override fun onBindViewHolder(
        holder: BasicViewHolder,
        position: Int
    ) = holder.onBind(items[position])

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = BasicViewHolder(
        RecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class BasicViewHolder(
        private val binding: RecyclerItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: BasicModelData) = with(binding) {
            employeeName.text = itemView.resources.getString(
                R.string.employee_name, item.employeeName
            )

            employeeSalary.text = itemView.resources.getString(
                R.string.employee_salary, item.employeeSalary
            )

            employeeAge.text = itemView.resources.getString(
                R.string.employee_age, item.employeeAge
            )
        }
    }
}