﻿#pragma warning disable 1591
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace WEBSERVICEAPI
{
	using System.Data.Linq;
	using System.Data.Linq.Mapping;
	using System.Data;
	using System.Collections.Generic;
	using System.Reflection;
	using System.Linq;
	using System.Linq.Expressions;
	using System.ComponentModel;
	using System;
	
	
	[global::System.Data.Linq.Mapping.DatabaseAttribute(Name="AGRISBOTSYSTEM")]
	public partial class AGRIBOTSYSTEMDataContext : System.Data.Linq.DataContext
	{
		
		private static System.Data.Linq.Mapping.MappingSource mappingSource = new AttributeMappingSource();
		
    #region Extensibility Method Definitions
    partial void OnCreated();
    partial void InsertDEVICE(DEVICE instance);
    partial void UpdateDEVICE(DEVICE instance);
    partial void DeleteDEVICE(DEVICE instance);
    partial void InsertDVMT(DVMT instance);
    partial void UpdateDVMT(DVMT instance);
    partial void DeleteDVMT(DVMT instance);
    partial void InsertSENSOR(SENSOR instance);
    partial void UpdateSENSOR(SENSOR instance);
    partial void DeleteSENSOR(SENSOR instance);
    partial void InsertMONITOR(MONITOR instance);
    partial void UpdateMONITOR(MONITOR instance);
    partial void DeleteMONITOR(MONITOR instance);
    partial void InsertDVSS(DVSS instance);
    partial void UpdateDVSS(DVSS instance);
    partial void DeleteDVSS(DVSS instance);
    partial void InsertTYPE_MT(TYPE_MT instance);
    partial void UpdateTYPE_MT(TYPE_MT instance);
    partial void DeleteTYPE_MT(TYPE_MT instance);
    partial void InsertTYPE_SS(TYPE_SS instance);
    partial void UpdateTYPE_SS(TYPE_SS instance);
    partial void DeleteTYPE_SS(TYPE_SS instance);
    partial void InsertUSER(USER instance);
    partial void UpdateUSER(USER instance);
    partial void DeleteUSER(USER instance);
    #endregion
		
		public AGRIBOTSYSTEMDataContext() : 
				base(global::System.Configuration.ConfigurationManager.ConnectionStrings["AGRISBOTSYSTEMConnectionString"].ConnectionString, mappingSource)
		{
			OnCreated();
		}
		
		public AGRIBOTSYSTEMDataContext(string connection) : 
				base(connection, mappingSource)
		{
			OnCreated();
		}
		
		public AGRIBOTSYSTEMDataContext(System.Data.IDbConnection connection) : 
				base(connection, mappingSource)
		{
			OnCreated();
		}
		
		public AGRIBOTSYSTEMDataContext(string connection, System.Data.Linq.Mapping.MappingSource mappingSource) : 
				base(connection, mappingSource)
		{
			OnCreated();
		}
		
		public AGRIBOTSYSTEMDataContext(System.Data.IDbConnection connection, System.Data.Linq.Mapping.MappingSource mappingSource) : 
				base(connection, mappingSource)
		{
			OnCreated();
		}
		
		public System.Data.Linq.Table<DEVICE> DEVICEs
		{
			get
			{
				return this.GetTable<DEVICE>();
			}
		}
		
		public System.Data.Linq.Table<DVMT> DVMTs
		{
			get
			{
				return this.GetTable<DVMT>();
			}
		}
		
		public System.Data.Linq.Table<SENSOR> SENSORs
		{
			get
			{
				return this.GetTable<SENSOR>();
			}
		}
		
		public System.Data.Linq.Table<MONITOR> MONITORs
		{
			get
			{
				return this.GetTable<MONITOR>();
			}
		}
		
		public System.Data.Linq.Table<DVSS> DVSSes
		{
			get
			{
				return this.GetTable<DVSS>();
			}
		}
		
		public System.Data.Linq.Table<TYPE_MT> TYPE_MTs
		{
			get
			{
				return this.GetTable<TYPE_MT>();
			}
		}
		
		public System.Data.Linq.Table<TYPE_SS> TYPE_SSes
		{
			get
			{
				return this.GetTable<TYPE_SS>();
			}
		}
		
		public System.Data.Linq.Table<USER> USERs
		{
			get
			{
				return this.GetTable<USER>();
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.DEVICE")]
	public partial class DEVICE : INotifyPropertyChanging, INotifyPropertyChanged
	{
		
		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
		
		private string _ID;
		
		private string _NAME;
		
		private System.Nullable<int> _STATUS;
		
		private EntitySet<DVMT> _DVMTs;
		
		private EntitySet<DVSS> _DVSSes;
		
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIDChanging(string value);
    partial void OnIDChanged();
    partial void OnNAMEChanging(string value);
    partial void OnNAMEChanged();
    partial void OnSTATUSChanging(System.Nullable<int> value);
    partial void OnSTATUSChanged();
    #endregion
		
		public DEVICE()
		{
			this._DVMTs = new EntitySet<DVMT>(new Action<DVMT>(this.attach_DVMTs), new Action<DVMT>(this.detach_DVMTs));
			this._DVSSes = new EntitySet<DVSS>(new Action<DVSS>(this.attach_DVSSes), new Action<DVSS>(this.detach_DVSSes));
			OnCreated();
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_ID", DbType="NChar(10) NOT NULL", CanBeNull=false, IsPrimaryKey=true)]
		public string ID
		{
			get
			{
				return this._ID;
			}
			set
			{
				if ((this._ID != value))
				{
					this.OnIDChanging(value);
					this.SendPropertyChanging();
					this._ID = value;
					this.SendPropertyChanged("ID");
					this.OnIDChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_NAME", DbType="NChar(50)")]
		public string NAME
		{
			get
			{
				return this._NAME;
			}
			set
			{
				if ((this._NAME != value))
				{
					this.OnNAMEChanging(value);
					this.SendPropertyChanging();
					this._NAME = value;
					this.SendPropertyChanged("NAME");
					this.OnNAMEChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_STATUS", DbType="Int")]
		public System.Nullable<int> STATUS
		{
			get
			{
				return this._STATUS;
			}
			set
			{
				if ((this._STATUS != value))
				{
					this.OnSTATUSChanging(value);
					this.SendPropertyChanging();
					this._STATUS = value;
					this.SendPropertyChanged("STATUS");
					this.OnSTATUSChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="DEVICE_DVMT", Storage="_DVMTs", ThisKey="ID", OtherKey="IDDV")]
		public EntitySet<DVMT> DVMTs
		{
			get
			{
				return this._DVMTs;
			}
			set
			{
				this._DVMTs.Assign(value);
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="DEVICE_DVSS", Storage="_DVSSes", ThisKey="ID", OtherKey="IDDV")]
		public EntitySet<DVSS> DVSSes
		{
			get
			{
				return this._DVSSes;
			}
			set
			{
				this._DVSSes.Assign(value);
			}
		}
		
		public event PropertyChangingEventHandler PropertyChanging;
		
		public event PropertyChangedEventHandler PropertyChanged;
		
		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}
		
		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
		
		private void attach_DVMTs(DVMT entity)
		{
			this.SendPropertyChanging();
			entity.DEVICE = this;
		}
		
		private void detach_DVMTs(DVMT entity)
		{
			this.SendPropertyChanging();
			entity.DEVICE = null;
		}
		
		private void attach_DVSSes(DVSS entity)
		{
			this.SendPropertyChanging();
			entity.DEVICE = this;
		}
		
		private void detach_DVSSes(DVSS entity)
		{
			this.SendPropertyChanging();
			entity.DEVICE = null;
		}
	}
	
	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.DVMT")]
	public partial class DVMT : INotifyPropertyChanging, INotifyPropertyChanged
	{
		
		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
		
		private string _IDDV;
		
		private string _IDMT;
		
		private EntityRef<DEVICE> _DEVICE;
		
		private EntityRef<MONITOR> _MONITOR;
		
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIDDVChanging(string value);
    partial void OnIDDVChanged();
    partial void OnIDMTChanging(string value);
    partial void OnIDMTChanged();
    #endregion
		
		public DVMT()
		{
			this._DEVICE = default(EntityRef<DEVICE>);
			this._MONITOR = default(EntityRef<MONITOR>);
			OnCreated();
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_IDDV", DbType="NChar(10) NOT NULL", CanBeNull=false, IsPrimaryKey=true)]
		public string IDDV
		{
			get
			{
				return this._IDDV;
			}
			set
			{
				if ((this._IDDV != value))
				{
					if (this._DEVICE.HasLoadedOrAssignedValue)
					{
						throw new System.Data.Linq.ForeignKeyReferenceAlreadyHasValueException();
					}
					this.OnIDDVChanging(value);
					this.SendPropertyChanging();
					this._IDDV = value;
					this.SendPropertyChanged("IDDV");
					this.OnIDDVChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_IDMT", DbType="NChar(10) NOT NULL", CanBeNull=false, IsPrimaryKey=true)]
		public string IDMT
		{
			get
			{
				return this._IDMT;
			}
			set
			{
				if ((this._IDMT != value))
				{
					if (this._MONITOR.HasLoadedOrAssignedValue)
					{
						throw new System.Data.Linq.ForeignKeyReferenceAlreadyHasValueException();
					}
					this.OnIDMTChanging(value);
					this.SendPropertyChanging();
					this._IDMT = value;
					this.SendPropertyChanged("IDMT");
					this.OnIDMTChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="DEVICE_DVMT", Storage="_DEVICE", ThisKey="IDDV", OtherKey="ID", IsForeignKey=true)]
		public DEVICE DEVICE
		{
			get
			{
				return this._DEVICE.Entity;
			}
			set
			{
				DEVICE previousValue = this._DEVICE.Entity;
				if (((previousValue != value) 
							|| (this._DEVICE.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._DEVICE.Entity = null;
						previousValue.DVMTs.Remove(this);
					}
					this._DEVICE.Entity = value;
					if ((value != null))
					{
						value.DVMTs.Add(this);
						this._IDDV = value.ID;
					}
					else
					{
						this._IDDV = default(string);
					}
					this.SendPropertyChanged("DEVICE");
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="MONITOR_DVMT", Storage="_MONITOR", ThisKey="IDMT", OtherKey="ID", IsForeignKey=true)]
		public MONITOR MONITOR
		{
			get
			{
				return this._MONITOR.Entity;
			}
			set
			{
				MONITOR previousValue = this._MONITOR.Entity;
				if (((previousValue != value) 
							|| (this._MONITOR.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._MONITOR.Entity = null;
						previousValue.DVMTs.Remove(this);
					}
					this._MONITOR.Entity = value;
					if ((value != null))
					{
						value.DVMTs.Add(this);
						this._IDMT = value.ID;
					}
					else
					{
						this._IDMT = default(string);
					}
					this.SendPropertyChanged("MONITOR");
				}
			}
		}
		
		public event PropertyChangingEventHandler PropertyChanging;
		
		public event PropertyChangedEventHandler PropertyChanged;
		
		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}
		
		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.SENSOR")]
	public partial class SENSOR : INotifyPropertyChanging, INotifyPropertyChanged
	{
		
		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
		
		private string _ID;
		
		private string _NAME;
		
		private System.Nullable<int> _STATUS;
		
		private string _NUMBER;
		
		private string _UNIT;
		
		private string _TYPE;
		
		private EntitySet<DVSS> _DVSSes;
		
		private EntityRef<TYPE_SS> _TYPE_SS;
		
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIDChanging(string value);
    partial void OnIDChanged();
    partial void OnNAMEChanging(string value);
    partial void OnNAMEChanged();
    partial void OnSTATUSChanging(System.Nullable<int> value);
    partial void OnSTATUSChanged();
    partial void OnNUMBERChanging(string value);
    partial void OnNUMBERChanged();
    partial void OnUNITChanging(string value);
    partial void OnUNITChanged();
    partial void OnTYPEChanging(string value);
    partial void OnTYPEChanged();
    #endregion
		
		public SENSOR()
		{
			this._DVSSes = new EntitySet<DVSS>(new Action<DVSS>(this.attach_DVSSes), new Action<DVSS>(this.detach_DVSSes));
			this._TYPE_SS = default(EntityRef<TYPE_SS>);
			OnCreated();
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_ID", DbType="NChar(10) NOT NULL", CanBeNull=false, IsPrimaryKey=true)]
		public string ID
		{
			get
			{
				return this._ID;
			}
			set
			{
				if ((this._ID != value))
				{
					this.OnIDChanging(value);
					this.SendPropertyChanging();
					this._ID = value;
					this.SendPropertyChanged("ID");
					this.OnIDChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_NAME", DbType="NChar(50)")]
		public string NAME
		{
			get
			{
				return this._NAME;
			}
			set
			{
				if ((this._NAME != value))
				{
					this.OnNAMEChanging(value);
					this.SendPropertyChanging();
					this._NAME = value;
					this.SendPropertyChanged("NAME");
					this.OnNAMEChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_STATUS", DbType="Int")]
		public System.Nullable<int> STATUS
		{
			get
			{
				return this._STATUS;
			}
			set
			{
				if ((this._STATUS != value))
				{
					this.OnSTATUSChanging(value);
					this.SendPropertyChanging();
					this._STATUS = value;
					this.SendPropertyChanged("STATUS");
					this.OnSTATUSChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_NUMBER", DbType="NChar(10)")]
		public string NUMBER
		{
			get
			{
				return this._NUMBER;
			}
			set
			{
				if ((this._NUMBER != value))
				{
					this.OnNUMBERChanging(value);
					this.SendPropertyChanging();
					this._NUMBER = value;
					this.SendPropertyChanged("NUMBER");
					this.OnNUMBERChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_UNIT", DbType="NChar(10)")]
		public string UNIT
		{
			get
			{
				return this._UNIT;
			}
			set
			{
				if ((this._UNIT != value))
				{
					this.OnUNITChanging(value);
					this.SendPropertyChanging();
					this._UNIT = value;
					this.SendPropertyChanged("UNIT");
					this.OnUNITChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_TYPE", DbType="NChar(10)")]
		public string TYPE
		{
			get
			{
				return this._TYPE;
			}
			set
			{
				if ((this._TYPE != value))
				{
					if (this._TYPE_SS.HasLoadedOrAssignedValue)
					{
						throw new System.Data.Linq.ForeignKeyReferenceAlreadyHasValueException();
					}
					this.OnTYPEChanging(value);
					this.SendPropertyChanging();
					this._TYPE = value;
					this.SendPropertyChanged("TYPE");
					this.OnTYPEChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="SENSOR_DVSS", Storage="_DVSSes", ThisKey="ID", OtherKey="IDSS")]
		public EntitySet<DVSS> DVSSes
		{
			get
			{
				return this._DVSSes;
			}
			set
			{
				this._DVSSes.Assign(value);
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="TYPE_SS_SENSOR", Storage="_TYPE_SS", ThisKey="TYPE", OtherKey="ID", IsForeignKey=true)]
		public TYPE_SS TYPE_SS
		{
			get
			{
				return this._TYPE_SS.Entity;
			}
			set
			{
				TYPE_SS previousValue = this._TYPE_SS.Entity;
				if (((previousValue != value) 
							|| (this._TYPE_SS.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._TYPE_SS.Entity = null;
						previousValue.SENSORs.Remove(this);
					}
					this._TYPE_SS.Entity = value;
					if ((value != null))
					{
						value.SENSORs.Add(this);
						this._TYPE = value.ID;
					}
					else
					{
						this._TYPE = default(string);
					}
					this.SendPropertyChanged("TYPE_SS");
				}
			}
		}
		
		public event PropertyChangingEventHandler PropertyChanging;
		
		public event PropertyChangedEventHandler PropertyChanged;
		
		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}
		
		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
		
		private void attach_DVSSes(DVSS entity)
		{
			this.SendPropertyChanging();
			entity.SENSOR = this;
		}
		
		private void detach_DVSSes(DVSS entity)
		{
			this.SendPropertyChanging();
			entity.SENSOR = null;
		}
	}
	
	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.MONITOR")]
	public partial class MONITOR : INotifyPropertyChanging, INotifyPropertyChanged
	{
		
		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
		
		private string _ID;
		
		private string _NAME;
		
		private System.Nullable<int> _STATUS;
		
		private string _TYPE;
		
		private EntitySet<DVMT> _DVMTs;
		
		private EntityRef<TYPE_MT> _TYPE_MT;
		
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIDChanging(string value);
    partial void OnIDChanged();
    partial void OnNAMEChanging(string value);
    partial void OnNAMEChanged();
    partial void OnSTATUSChanging(System.Nullable<int> value);
    partial void OnSTATUSChanged();
    partial void OnTYPEChanging(string value);
    partial void OnTYPEChanged();
    #endregion
		
		public MONITOR()
		{
			this._DVMTs = new EntitySet<DVMT>(new Action<DVMT>(this.attach_DVMTs), new Action<DVMT>(this.detach_DVMTs));
			this._TYPE_MT = default(EntityRef<TYPE_MT>);
			OnCreated();
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_ID", DbType="NChar(10) NOT NULL", CanBeNull=false, IsPrimaryKey=true)]
		public string ID
		{
			get
			{
				return this._ID;
			}
			set
			{
				if ((this._ID != value))
				{
					this.OnIDChanging(value);
					this.SendPropertyChanging();
					this._ID = value;
					this.SendPropertyChanged("ID");
					this.OnIDChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_NAME", DbType="NChar(50)")]
		public string NAME
		{
			get
			{
				return this._NAME;
			}
			set
			{
				if ((this._NAME != value))
				{
					this.OnNAMEChanging(value);
					this.SendPropertyChanging();
					this._NAME = value;
					this.SendPropertyChanged("NAME");
					this.OnNAMEChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_STATUS", DbType="Int")]
		public System.Nullable<int> STATUS
		{
			get
			{
				return this._STATUS;
			}
			set
			{
				if ((this._STATUS != value))
				{
					this.OnSTATUSChanging(value);
					this.SendPropertyChanging();
					this._STATUS = value;
					this.SendPropertyChanged("STATUS");
					this.OnSTATUSChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_TYPE", DbType="NChar(10)")]
		public string TYPE
		{
			get
			{
				return this._TYPE;
			}
			set
			{
				if ((this._TYPE != value))
				{
					if (this._TYPE_MT.HasLoadedOrAssignedValue)
					{
						throw new System.Data.Linq.ForeignKeyReferenceAlreadyHasValueException();
					}
					this.OnTYPEChanging(value);
					this.SendPropertyChanging();
					this._TYPE = value;
					this.SendPropertyChanged("TYPE");
					this.OnTYPEChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="MONITOR_DVMT", Storage="_DVMTs", ThisKey="ID", OtherKey="IDMT")]
		public EntitySet<DVMT> DVMTs
		{
			get
			{
				return this._DVMTs;
			}
			set
			{
				this._DVMTs.Assign(value);
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="TYPE_MT_MONITOR", Storage="_TYPE_MT", ThisKey="TYPE", OtherKey="ID", IsForeignKey=true)]
		public TYPE_MT TYPE_MT
		{
			get
			{
				return this._TYPE_MT.Entity;
			}
			set
			{
				TYPE_MT previousValue = this._TYPE_MT.Entity;
				if (((previousValue != value) 
							|| (this._TYPE_MT.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._TYPE_MT.Entity = null;
						previousValue.MONITORs.Remove(this);
					}
					this._TYPE_MT.Entity = value;
					if ((value != null))
					{
						value.MONITORs.Add(this);
						this._TYPE = value.ID;
					}
					else
					{
						this._TYPE = default(string);
					}
					this.SendPropertyChanged("TYPE_MT");
				}
			}
		}
		
		public event PropertyChangingEventHandler PropertyChanging;
		
		public event PropertyChangedEventHandler PropertyChanged;
		
		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}
		
		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
		
		private void attach_DVMTs(DVMT entity)
		{
			this.SendPropertyChanging();
			entity.MONITOR = this;
		}
		
		private void detach_DVMTs(DVMT entity)
		{
			this.SendPropertyChanging();
			entity.MONITOR = null;
		}
	}
	
	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.DVSS")]
	public partial class DVSS : INotifyPropertyChanging, INotifyPropertyChanged
	{
		
		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
		
		private string _IDDV;
		
		private string _IDSS;
		
		private EntityRef<DEVICE> _DEVICE;
		
		private EntityRef<SENSOR> _SENSOR;
		
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIDDVChanging(string value);
    partial void OnIDDVChanged();
    partial void OnIDSSChanging(string value);
    partial void OnIDSSChanged();
    #endregion
		
		public DVSS()
		{
			this._DEVICE = default(EntityRef<DEVICE>);
			this._SENSOR = default(EntityRef<SENSOR>);
			OnCreated();
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_IDDV", DbType="NChar(10) NOT NULL", CanBeNull=false, IsPrimaryKey=true)]
		public string IDDV
		{
			get
			{
				return this._IDDV;
			}
			set
			{
				if ((this._IDDV != value))
				{
					if (this._DEVICE.HasLoadedOrAssignedValue)
					{
						throw new System.Data.Linq.ForeignKeyReferenceAlreadyHasValueException();
					}
					this.OnIDDVChanging(value);
					this.SendPropertyChanging();
					this._IDDV = value;
					this.SendPropertyChanged("IDDV");
					this.OnIDDVChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_IDSS", DbType="NChar(10) NOT NULL", CanBeNull=false, IsPrimaryKey=true)]
		public string IDSS
		{
			get
			{
				return this._IDSS;
			}
			set
			{
				if ((this._IDSS != value))
				{
					if (this._SENSOR.HasLoadedOrAssignedValue)
					{
						throw new System.Data.Linq.ForeignKeyReferenceAlreadyHasValueException();
					}
					this.OnIDSSChanging(value);
					this.SendPropertyChanging();
					this._IDSS = value;
					this.SendPropertyChanged("IDSS");
					this.OnIDSSChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="DEVICE_DVSS", Storage="_DEVICE", ThisKey="IDDV", OtherKey="ID", IsForeignKey=true)]
		public DEVICE DEVICE
		{
			get
			{
				return this._DEVICE.Entity;
			}
			set
			{
				DEVICE previousValue = this._DEVICE.Entity;
				if (((previousValue != value) 
							|| (this._DEVICE.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._DEVICE.Entity = null;
						previousValue.DVSSes.Remove(this);
					}
					this._DEVICE.Entity = value;
					if ((value != null))
					{
						value.DVSSes.Add(this);
						this._IDDV = value.ID;
					}
					else
					{
						this._IDDV = default(string);
					}
					this.SendPropertyChanged("DEVICE");
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="SENSOR_DVSS", Storage="_SENSOR", ThisKey="IDSS", OtherKey="ID", IsForeignKey=true)]
		public SENSOR SENSOR
		{
			get
			{
				return this._SENSOR.Entity;
			}
			set
			{
				SENSOR previousValue = this._SENSOR.Entity;
				if (((previousValue != value) 
							|| (this._SENSOR.HasLoadedOrAssignedValue == false)))
				{
					this.SendPropertyChanging();
					if ((previousValue != null))
					{
						this._SENSOR.Entity = null;
						previousValue.DVSSes.Remove(this);
					}
					this._SENSOR.Entity = value;
					if ((value != null))
					{
						value.DVSSes.Add(this);
						this._IDSS = value.ID;
					}
					else
					{
						this._IDSS = default(string);
					}
					this.SendPropertyChanged("SENSOR");
				}
			}
		}
		
		public event PropertyChangingEventHandler PropertyChanging;
		
		public event PropertyChangedEventHandler PropertyChanged;
		
		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}
		
		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.TYPE_MT")]
	public partial class TYPE_MT : INotifyPropertyChanging, INotifyPropertyChanged
	{
		
		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
		
		private string _ID;
		
		private string _NAME;
		
		private EntitySet<MONITOR> _MONITORs;
		
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIDChanging(string value);
    partial void OnIDChanged();
    partial void OnNAMEChanging(string value);
    partial void OnNAMEChanged();
    #endregion
		
		public TYPE_MT()
		{
			this._MONITORs = new EntitySet<MONITOR>(new Action<MONITOR>(this.attach_MONITORs), new Action<MONITOR>(this.detach_MONITORs));
			OnCreated();
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_ID", DbType="NChar(10) NOT NULL", CanBeNull=false, IsPrimaryKey=true)]
		public string ID
		{
			get
			{
				return this._ID;
			}
			set
			{
				if ((this._ID != value))
				{
					this.OnIDChanging(value);
					this.SendPropertyChanging();
					this._ID = value;
					this.SendPropertyChanged("ID");
					this.OnIDChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_NAME", DbType="NChar(50)")]
		public string NAME
		{
			get
			{
				return this._NAME;
			}
			set
			{
				if ((this._NAME != value))
				{
					this.OnNAMEChanging(value);
					this.SendPropertyChanging();
					this._NAME = value;
					this.SendPropertyChanged("NAME");
					this.OnNAMEChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="TYPE_MT_MONITOR", Storage="_MONITORs", ThisKey="ID", OtherKey="TYPE")]
		public EntitySet<MONITOR> MONITORs
		{
			get
			{
				return this._MONITORs;
			}
			set
			{
				this._MONITORs.Assign(value);
			}
		}
		
		public event PropertyChangingEventHandler PropertyChanging;
		
		public event PropertyChangedEventHandler PropertyChanged;
		
		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}
		
		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
		
		private void attach_MONITORs(MONITOR entity)
		{
			this.SendPropertyChanging();
			entity.TYPE_MT = this;
		}
		
		private void detach_MONITORs(MONITOR entity)
		{
			this.SendPropertyChanging();
			entity.TYPE_MT = null;
		}
	}
	
	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.TYPE_SS")]
	public partial class TYPE_SS : INotifyPropertyChanging, INotifyPropertyChanged
	{
		
		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
		
		private string _ID;
		
		private string _NAME;
		
		private EntitySet<SENSOR> _SENSORs;
		
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIDChanging(string value);
    partial void OnIDChanged();
    partial void OnNAMEChanging(string value);
    partial void OnNAMEChanged();
    #endregion
		
		public TYPE_SS()
		{
			this._SENSORs = new EntitySet<SENSOR>(new Action<SENSOR>(this.attach_SENSORs), new Action<SENSOR>(this.detach_SENSORs));
			OnCreated();
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_ID", DbType="NChar(10) NOT NULL", CanBeNull=false, IsPrimaryKey=true)]
		public string ID
		{
			get
			{
				return this._ID;
			}
			set
			{
				if ((this._ID != value))
				{
					this.OnIDChanging(value);
					this.SendPropertyChanging();
					this._ID = value;
					this.SendPropertyChanged("ID");
					this.OnIDChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_NAME", DbType="NChar(50)")]
		public string NAME
		{
			get
			{
				return this._NAME;
			}
			set
			{
				if ((this._NAME != value))
				{
					this.OnNAMEChanging(value);
					this.SendPropertyChanging();
					this._NAME = value;
					this.SendPropertyChanged("NAME");
					this.OnNAMEChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.AssociationAttribute(Name="TYPE_SS_SENSOR", Storage="_SENSORs", ThisKey="ID", OtherKey="TYPE")]
		public EntitySet<SENSOR> SENSORs
		{
			get
			{
				return this._SENSORs;
			}
			set
			{
				this._SENSORs.Assign(value);
			}
		}
		
		public event PropertyChangingEventHandler PropertyChanging;
		
		public event PropertyChangedEventHandler PropertyChanged;
		
		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}
		
		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
		
		private void attach_SENSORs(SENSOR entity)
		{
			this.SendPropertyChanging();
			entity.TYPE_SS = this;
		}
		
		private void detach_SENSORs(SENSOR entity)
		{
			this.SendPropertyChanging();
			entity.TYPE_SS = null;
		}
	}
	
	[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.[USER]")]
	public partial class USER : INotifyPropertyChanging, INotifyPropertyChanged
	{
		
		private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
		
		private string _ID;
		
		private string _USN;
		
		private string _PASS;
		
		private string _NAME;
		
		private string _ADDRESS;
		
		private string _NUMPHONE;
		
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIDChanging(string value);
    partial void OnIDChanged();
    partial void OnUSNChanging(string value);
    partial void OnUSNChanged();
    partial void OnPASSChanging(string value);
    partial void OnPASSChanged();
    partial void OnNAMEChanging(string value);
    partial void OnNAMEChanged();
    partial void OnADDRESSChanging(string value);
    partial void OnADDRESSChanged();
    partial void OnNUMPHONEChanging(string value);
    partial void OnNUMPHONEChanged();
    #endregion
		
		public USER()
		{
			OnCreated();
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_ID", DbType="NChar(10) NOT NULL", CanBeNull=false, IsPrimaryKey=true)]
		public string ID
		{
			get
			{
				return this._ID;
			}
			set
			{
				if ((this._ID != value))
				{
					this.OnIDChanging(value);
					this.SendPropertyChanging();
					this._ID = value;
					this.SendPropertyChanged("ID");
					this.OnIDChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_USN", DbType="NChar(16)")]
		public string USN
		{
			get
			{
				return this._USN;
			}
			set
			{
				if ((this._USN != value))
				{
					this.OnUSNChanging(value);
					this.SendPropertyChanging();
					this._USN = value;
					this.SendPropertyChanged("USN");
					this.OnUSNChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_PASS", DbType="NChar(16)")]
		public string PASS
		{
			get
			{
				return this._PASS;
			}
			set
			{
				if ((this._PASS != value))
				{
					this.OnPASSChanging(value);
					this.SendPropertyChanging();
					this._PASS = value;
					this.SendPropertyChanged("PASS");
					this.OnPASSChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_NAME", DbType="NChar(50)")]
		public string NAME
		{
			get
			{
				return this._NAME;
			}
			set
			{
				if ((this._NAME != value))
				{
					this.OnNAMEChanging(value);
					this.SendPropertyChanging();
					this._NAME = value;
					this.SendPropertyChanged("NAME");
					this.OnNAMEChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_ADDRESS", DbType="NChar(200)")]
		public string ADDRESS
		{
			get
			{
				return this._ADDRESS;
			}
			set
			{
				if ((this._ADDRESS != value))
				{
					this.OnADDRESSChanging(value);
					this.SendPropertyChanging();
					this._ADDRESS = value;
					this.SendPropertyChanged("ADDRESS");
					this.OnADDRESSChanged();
				}
			}
		}
		
		[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_NUMPHONE", DbType="NChar(10)")]
		public string NUMPHONE
		{
			get
			{
				return this._NUMPHONE;
			}
			set
			{
				if ((this._NUMPHONE != value))
				{
					this.OnNUMPHONEChanging(value);
					this.SendPropertyChanging();
					this._NUMPHONE = value;
					this.SendPropertyChanged("NUMPHONE");
					this.OnNUMPHONEChanged();
				}
			}
		}
		
		public event PropertyChangingEventHandler PropertyChanging;
		
		public event PropertyChangedEventHandler PropertyChanged;
		
		protected virtual void SendPropertyChanging()
		{
			if ((this.PropertyChanging != null))
			{
				this.PropertyChanging(this, emptyChangingEventArgs);
			}
		}
		
		protected virtual void SendPropertyChanged(String propertyName)
		{
			if ((this.PropertyChanged != null))
			{
				this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
			}
		}
	}
}
#pragma warning restore 1591