package dani.kotlin.template.basicrecycler.model

import com.google.gson.annotations.SerializedName

data class BasicModel(
    val status: String,
    val data: List<BasicModelData>
)

data class BasicModelData(
    val id: String,

    @SerializedName("employee_name")
    val employeeName: String,

    @SerializedName("employee_salary")
    val employeeSalary: String,

    @SerializedName("employee_age")
    val employeeAge: String,

    @SerializedName("profile_image")
    val profileImage: String
)