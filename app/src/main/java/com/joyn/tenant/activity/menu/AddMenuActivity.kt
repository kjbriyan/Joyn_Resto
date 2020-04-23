package com.joyn.tenant.activity.menu

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.joyn.tenant.R
import com.joyn.tenant.activity.fragment.submit.response.MenusItem
import com.joyn.tenant.activity.webservice.Retrofit
import com.joyn.tenant.utils.Helper
import kotlinx.android.synthetic.main.activity_add_menu2.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class AddMenuActivity : AppCompatActivity() {

    lateinit var menu: AddMenuModel
    lateinit var body: RequestBody
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_menu2)

        val param = intent.getStringExtra("param") as String
        var id: String? = null
        var dataMenu: MenusItem? = null
        menu = AddMenuModel()

        if (param.equals("add")) {
            id = intent.getStringExtra("id")
            addMenu(id)
            btn_add_menu.visibility = View.VISIBLE
            btn_update_menu.visibility = View.GONE
            btn_delete_menu.visibility = View.GONE
        } else {
            dataMenu = intent.getParcelableExtra("menu") as MenusItem
            setMenu(dataMenu)
            btn_add_menu.visibility = View.GONE
            btn_update_menu.visibility = View.VISIBLE
            btn_delete_menu.visibility = View.VISIBLE
        }
    }

    private fun addMenu(id: String) {
        btn_add_menu.setOnClickListener {

            getMenu(id.toInt(), null)

            CoroutineScope(IO).launch {
                try {
                    val response = Retrofit.Instance.add_menu(body)
                    Helper().debuger("Menu response -> ${response.body()}")
                    if (response.isSuccessful) finish()
                } catch (e: Exception) {
                    Helper().debuger("Menu  error -> ${e.message}")
                }
            }
        }
    }

    private fun setMenu(menu: MenusItem) {
        et_nama_menu.setText(menu.restaurantMenuName)
        et_desc_menu.setText(menu.restaurantMenuDesc)
        et_stok_menu.setText(menu.restaurantMenuStockCount.toString())
        et_harga_menu.setText(menu.restaurantMenuPrice.toString())
        Helper().debuger("Menu ${menu.restaurantMenucatId}")

        btn_update_menu.setOnClickListener {
            setUpdate(
                menu.restaurantMenucatId!!.toInt(),
                menu.restaurantMenuId!!.toInt()
            )
        }

        btn_delete_menu.setOnClickListener {
            setDelete(menu.restaurantMenuId!!.toInt())
        }
    }

    private fun setDelete(id: Int) {
        menu.restaurantMenuId = id
        val gson = Gson()
        val data = gson.toJson(menu)
        val mediaType = "application/json; charset=utf-8".toMediaType()
        body = data.toRequestBody(mediaType)

        CoroutineScope(IO).launch {
            try {
                val response = Retrofit.Instance.deleteMenu(body)

                if (response.isSuccessful) finish()
            } catch (e: Exception) {
                Helper().debuger(" delete $e")
            }
        }
    }

    private fun setUpdate(id: Int, menuId: Int) {

        getMenu(id, menuId)
        try {
            CoroutineScope(IO).launch {
                val response = Retrofit.Instance.updateMenu(body)
                if (response.isSuccessful) finish()
            }
        } catch (e: Exception) {
            Helper().debuger(" Update ${e.message}")
        }
    }

    private fun getMenu(id: Int, menuId: Int?) {
        Helper().debuger(" Update $id,  menu $menuId")
        menu.restaurantMenuId = menuId
        menu.restaurantMenucatId = id
        menu.restaurantMenuName = et_nama_menu.text.toString()
        menu.restaurantMenuDesc = et_desc_menu.text.toString()
        menu.restaurantMenuStockCount = et_stok_menu.text.toString().toInt()
        menu.restaurantMenuStockMax = 10
        menu.restaurantMenuPrice = et_harga_menu.text.toString().toInt()
        menu.restaurantMenuPhotoUrl = "http://photo.jpeg"
        menu.restaurantMenuIsPromo = 0
        menu.restaurantMenuPromoType = "PERCENT"
        menu.restaurantMenuPromoCount = 10

        val gson = Gson()
        val data = gson.toJson(menu)
        val mediaType = "application/json; charset=utf-8".toMediaType()
        body = data.toRequestBody(mediaType)
    }

}
