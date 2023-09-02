package mai.hu.beast.first.foodbiller

import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    private lateinit var cbPaneer: CheckBox
    private lateinit var cbMushroom: CheckBox
    private lateinit var cbOnions: CheckBox
    private lateinit var cbCapscicum: CheckBox
    private lateinit var cbNoToppings: CheckBox
    private lateinit var billAmt: TextView
    private var baseAmt = 100
    private var totalBillAmt = baseAmt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cbPaneer = findViewById(R.id.cbPaneer)
        cbMushroom = findViewById(R.id.cbMushroom)
        cbOnions = findViewById(R.id.cbOnions)
        cbCapscicum = findViewById(R.id.cbCapscicum)
        cbNoToppings = findViewById(R.id.cbNoToppings)
        billAmt = findViewById(R.id.billAmt)

        cbPaneer.setOnCheckedChangeListener { _, _ -> updateBillAmt() }
        cbMushroom.setOnCheckedChangeListener { _, _ -> updateBillAmt() }
        cbOnions.setOnCheckedChangeListener { _, _ -> updateBillAmt() }
        cbCapscicum.setOnCheckedChangeListener { _, _ -> updateBillAmt() }
        cbNoToppings.setOnCheckedChangeListener { _, _ -> updateBillAmt() }
    }

    private fun updateBillAmt() {
        totalBillAmt = baseAmt

        if (cbPaneer.isChecked) {
            totalBillAmt += 100
        }
        if (cbMushroom.isChecked) {
            totalBillAmt += 50
        }
        if (cbOnions.isChecked) {
            totalBillAmt += 40
        }
        if (cbCapscicum.isChecked) {
            totalBillAmt += 30
        }

        billAmt.text = "Your Bill Amount: Rs. $totalBillAmt"
    }
}

