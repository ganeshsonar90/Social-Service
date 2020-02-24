package com.task.ui.component.home_categories.categoriesAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.task.R
import com.task.data.models.db.Category
import com.task.ui.base.listeners.RecyclerItemListener
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


/**
 *
 */

class CategoryViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(item: Category, recyclerItemListener: RecyclerItemListener) {
        textView_title?.text = item?.title

        item?.totalValue?.let {
            textView_goals_price?.text = "₹ " + item.totalValue
        }

        item?.collectedValue?.let {
            textView_fund_price?.text = "₹ " + item.collectedValue
        }



        getDaysDiffFromDates(item)


        item?.shortDescription?.let {
            textView_desc?.text = "" + item.shortDescription
        }


        item?.mainImageURL.isNullOrEmpty().let {
            if (!it) {
                val imageUrl: String = item?.mainImageURL.replace("http", "https")
                Picasso.get().load(imageUrl).fit().placeholder(R.drawable.place_holder).into(imageView_back)

            }

        }

        rl_social_item.setOnClickListener { recyclerItemListener.onItemSelected(item) }
    }

    private fun getDaysDiffFromDates(item: Category) {
        var createdDateString: String? = null
        var expireDateString: String? = null


        createdDateString = item.startDate
        expireDateString = item.endDate


        //23/05/2018
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        var createdConvertedDate: Date? = null
        var expireCovertedDate: Date? = null
        try {
            createdConvertedDate = dateFormat.parse(createdDateString)

            expireCovertedDate = dateFormat.parse(expireDateString)


            val startCal = Calendar.getInstance()
            val endCal = Calendar.getInstance()

            startCal.setTime(createdConvertedDate)
            endCal.setTime(expireCovertedDate)


            val msDiff: Long = endCal.getTimeInMillis() - startCal.getTimeInMillis()
            val daysDiff: Int = TimeUnit.MILLISECONDS.toDays(msDiff).toInt()


            textView_goals_ends?.text = "" + daysDiff

        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }
}

