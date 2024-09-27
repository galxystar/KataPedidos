package kata.es.publico.tech.kataPedidos.domain;


public class Pedido {
	  	private String uuid;
	    private String id;
	    private String region;
	    private String country;
	    private String item_type;
	    private String sales_channel;
	    private String priority;
	    private String date;
	    private String ship_date;
	    private int units_sold;
	    private double unit_price;
	    private double unit_cost;
	    private double total_revenue;
	    private double total_cost;
	    private double total_profit;
	    
	    // Getters y setters 

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getItem_type() {
		return item_type;
	}

	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}

	public String getSales_channel() {
		return sales_channel;
	}

	public void setSales_channel(String sales_channel) {
		this.sales_channel = sales_channel;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getShip_date() {
		return ship_date;
	}

	public void setShip_date(String ship_date) {
		this.ship_date = ship_date;
	}

	public int getUnits_sold() {
		return units_sold;
	}

	public void setUnits_sold(int units_sold) {
		this.units_sold = units_sold;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public double getUnit_cost() {
		return unit_cost;
	}

	public void setUnit_cost(double unit_cost) {
		this.unit_cost = unit_cost;
	}

	public double getTotal_revenue() {
		return total_revenue;
	}

	public void setTotal_revenue(double total_revenue) {
		this.total_revenue = total_revenue;
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}

	public double getTotal_profit() {
		return total_profit;
	}

	public void setTotal_profit(double total_profit) {
		this.total_profit = total_profit;
	}

	}

