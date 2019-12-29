using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace WEBSERVICEAPI.Controllers
{
    public class USER_DEVICEController : ApiController
    {
        [HttpPost]
        public bool LuuUserDevice(string ID_User, string ID_Device)
        {
            try
            {
                AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();
                USR_DV dv = new USR_DV();
                dv.IDDV = ID_Device;
                dv.IDUSR = ID_User;
                dv.DateConnect = DateTime.Now.Date;
                context.USR_DVs.InsertOnSubmit(dv);
                context.SubmitChanges();
                return true;
            }
            catch
            {

            }
            return false;
        }

        [HttpGet]
        public List<DEVICE> DanhSachThietBiCuaNguoiDung(string IDUser)
        {
            AGRIBOTSYSTEMDataContext context = new AGRIBOTSYSTEMDataContext();
            List<USR_DV> lstUserDevice = context.USR_DVs
                .Where(x=>x.IDUSR==IDUser)
                .ToList();

            var list = new List<USR_DV>();
            foreach (var e in lstUserDevice)
            {
                list.Add(new USR_DV
                {
                    IDDV = e.IDDV,
                    IDUSR = e.IDUSR
                });
            }

            List<DEVICE> lstDevice = new List<DEVICE>();

            foreach(var item in list)
            {
                DEVICE dv = context.DEVICEs.FirstOrDefault(x => x.ID == item.IDDV);
                dv.USR_DVs = null;
                dv.DVSSes = null;
                dv.DVMTs = null;
            

                lstDevice.Add(dv);
            }
            return lstDevice;
        }
    }
}
