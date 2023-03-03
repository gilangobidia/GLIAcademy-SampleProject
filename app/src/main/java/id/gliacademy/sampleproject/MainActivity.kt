package id.gliacademy.sampleproject

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.Calendar

class MainActivity : AppCompatActivity() {

  private lateinit var etFullName: EditText
  private lateinit var etEmail: EditText
  private lateinit var rgGender: RadioGroup
  private lateinit var rbGenderMale: RadioButton
  private lateinit var rbGenderFemale: RadioButton
  private lateinit var etDob: EditText
  private lateinit var etAddress: EditText
  private lateinit var spinnerLastEducation: Spinner
  private lateinit var btnRegister: Button
  private lateinit var tvRegisterResult: TextView

  private lateinit var tvFullNameError: TextView
  private lateinit var tvEmailError: TextView
  private lateinit var tvGenderError: TextView
  private lateinit var tvDobError: TextView
  private lateinit var tvAddressError: TextView
  private lateinit var tvLastEducationError: TextView

  private val calendar = Calendar.getInstance()

  private lateinit var mainModel: MainModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    mainModel = MainModel()

    setupView()
    setupListener()
  }

  private fun setupView() {
    etFullName = findViewById(R.id.et_full_name)
    etEmail = findViewById(R.id.et_email)
    rgGender = findViewById(R.id.rg_gender)
    rbGenderMale = findViewById(R.id.rb_gender_male)
    rbGenderFemale = findViewById(R.id.rb_gender_female)
    etDob = findViewById(R.id.et_dob)
    etAddress = findViewById(R.id.et_address)
    spinnerLastEducation = findViewById(R.id.spinner_last_education)
    btnRegister = findViewById(R.id.btn_register)
    tvRegisterResult = findViewById(R.id.tv_register_result)

    tvFullNameError = findViewById(R.id.tv_full_name_error)
    tvEmailError = findViewById(R.id.tv_email_error)
    tvGenderError = findViewById(R.id.tv_gender_error)
    tvDobError = findViewById(R.id.tv_dob_error)
    tvAddressError = findViewById(R.id.tv_address_error)
    tvLastEducationError = findViewById(R.id.tv_last_education_error)
  }

  private fun setupListener() {
    etDob.setOnClickListener {
      showCalendar()
    }

    btnRegister.setOnClickListener {
      mainModel.fullName = etFullName.text.toString()
      mainModel.email = etEmail.text.toString()
      mainModel.gender = if (rbGenderFemale.isChecked) mainModel.GENDER_FEMALE else if (rbGenderMale.isChecked) mainModel.GENDER_MALE else null
      mainModel.dob = etDob.text.toString()
      mainModel.address = etAddress.text.toString()
      mainModel.lastEducationId = spinnerLastEducation.selectedItemPosition
      mainModel.lastEducation = spinnerLastEducation.selectedItem.toString()

      validate()
    }
  }

  private fun validate() {
    val isValidFullName = isValidFullName()
    val isValidEmail = isValidEmail()
    val isValidDob = isValidDob()
    val isValidGender = isValidGender()
    val isValidAddress = isValidAddress()
    val isValidLastEducation = isValidLastEducation()

    val isValid = isValidFullName && isValidEmail && isValidDob && isValidGender && isValidAddress && isValidLastEducation

    tvRegisterResult.visibility = View.VISIBLE
    tvRegisterResult.setTextColor(ContextCompat.getColorStateList(this, if (isValid) R.color.message_success else R.color.message_error))
    tvRegisterResult.text = if (isValid) getString(R.string.registration_success) else getString(R.string.registration_failed)
  }

  private fun isValidFullName(): Boolean {
    if (mainModel.fullName.isEmpty()) {
      tvFullNameError.visibility = View.VISIBLE
      tvFullNameError.text = getString(R.string.full_name_error_empty)
      return false
    }

    if (mainModel.fullName.length !in mainModel.MIN_FULL_NAME_LENGTH..mainModel.MAX_FULL_NAME_LENGTH) {
      tvFullNameError.visibility = View.VISIBLE
      tvFullNameError.text = getString(R.string.full_name_error_min_max_character)
      return false
    }

    tvFullNameError.visibility = View.GONE
    return true
  }

  private fun isValidEmail(): Boolean {
    if (mainModel.email.isEmpty()) {
      tvEmailError.visibility = View.VISIBLE
      tvEmailError.text = getString(R.string.email_error_empty)
      return false
    }

    tvEmailError.visibility = View.GONE

    return true
  }


  private fun isValidGender(): Boolean {
    if (mainModel.gender == null) {
      tvGenderError.visibility = View.VISIBLE
      tvGenderError.text = getString(R.string.gender_error_empty)
      return false
    }

    tvGenderError.visibility = View.GONE

    return true
  }


  private fun isValidDob(): Boolean {
    if (mainModel.dob.isEmpty()) {
      tvDobError.visibility = View.VISIBLE
      tvDobError.text = getString(R.string.dob_error_empty)
      return false
    }

    tvDobError.visibility = View.GONE

    return true
  }


  private fun isValidAddress(): Boolean {
    if (mainModel.address.isEmpty()) {
      tvAddressError.visibility = View.VISIBLE
      tvAddressError.text = getString(R.string.address_error_empty)
      return false
    }

    tvAddressError.visibility = View.GONE

    return true
  }


  private fun isValidLastEducation(): Boolean {
    if (mainModel.lastEducation.isEmpty() || mainModel.lastEducationId == 0) {
      tvLastEducationError.visibility = View.VISIBLE
      tvLastEducationError.text = getString(R.string.last_education_error_empty)
      return false
    }

    tvLastEducationError.visibility = View.GONE

    return true
  }

  private fun showCalendar() {
    val dpd = DatePickerDialog(this, { _, year, monthOfYear, dayOfMonth ->
      etDob.setText(getString(R.string.date_format, dayOfMonth, monthOfYear + 1, year))
    }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
    dpd.show()
  }

}