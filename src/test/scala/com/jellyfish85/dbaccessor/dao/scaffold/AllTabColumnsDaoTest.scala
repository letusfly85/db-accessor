package scala.com.jellyfish85.dbaccessor.dao.scaffold

import org.specs2.mutable.Specification
import com.jellyfish85.dbaccessor.manager.DatabaseManager

import java.math.BigDecimal
import com.jellyfish85.dbaccessor.dao.scaffold.AllTabColumnsDao
import com.jellyfish85.dbaccessor.bean.scaffold.AllTabColumnsBean

/**
 *
 *
 *
 *
 */
class AllTabColumnsDaoTest extends Specification {
  val db  = new DatabaseManager
  val dao = new AllTabColumnsDao

  def setup {

  }

  "return true" should {
    db.connect

    val bean01: AllTabColumnsBean  = new AllTabColumnsBean
    bean01.ownerAttr.value     = db.user
    bean01.tableNameAttr.value = "MS_TABLES"

    val _bean: AllTabColumnsBean = dao.find(db.conn, bean01)(0)

    db.jClose

    "return true for MS_TABLES" in {

      _bean.tableNameAttr.value     must beEqualTo("MS_TABLES")
      _bean.columnIdAttr.value      must beEqualTo(new BigDecimal(1))
      _bean.columnNameAttr.value    must beEqualTo("TRKM_ID")
      _bean.dataTypeAttr.value      must beEqualTo("NUMBER")
      _bean.dataLengthAttr.value    must beEqualTo(new BigDecimal(22))
      _bean.dataPrecisionAttr.value must beEqualTo(new BigDecimal(38))
      _bean.dataScaleAttr.value     must beEqualTo(new BigDecimal(0))
      _bean.nullableAttr.value      must beEqualTo("N")

    }
  }
}
