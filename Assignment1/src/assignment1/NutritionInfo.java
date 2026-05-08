package assignment1;

/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8284 313
 * Lab Professor: Sandra Iroakazi
 * Lab number: Assignment 1
 */


/** Represents the nutrition facts for a single food item.
 *  This class stores various nutrient values and provides methods to compute percentages
 *  and determine if certain nutrients are a good source in the food.
 *  It also offers methods to generate human-readable reports and labels.
 *  @see Driver
 *  @author Jay Chao
 */
public class NutritionInfo {
	private int servingSize;
	private String unit;
	private double calories;
	private double fat;
	private double saturatedFat;
	private double transFat;
	private double carbohydrates;
	private double fibre;
	private double sugars;
	private double protein;
	private double cholesterol;
	private double sodium;
	private double potassium;
	private double calcium;
	private double iron;
	private double vitaminD;
	
	/**
	 * No-argument Constructor
	 * Initializes all numeric fields to zero and sets unit to the default value of "grams".
	 */
	public NutritionInfo() {
		this(0,"gram",0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0);
	}

	/**
	 * Parameterized Constructor
	 * @param servingSize the serving size amount
	 * @param unit the unit of measurement for serving size
	 * @param calories total calories per serving
	 * @param fat total fat per serving
	 * @param saturatedFat saturated fat per serving
	 * @param transFat trans fat per serving
	 * @param cholesterol cholesterol per serving
	 * @param sodium sodium per serving
	 * @param carbohydrates total carbohydrates per serving
	 * @param fibre dietary fibre per serving
	 * @param sugars total sugars per serving
	 * @param protein protein per serving
	 * @param potassium potassium per serving
	 * @param calcium calcium per serving
	 * @param iron iron per serving
	 * @param vitaminD vitamin D per serving
	 * */
	public NutritionInfo(int servingSize, String unit, double calories, double fat, double saturatedFat, double transFat,
			double carbohydrates, double fibre, double sugars, double protein, double cholesterol, double sodium,
			double potassium, double calcium, double iron, double vitaminD) {
		this.servingSize = servingSize;
		this.unit = unit;
		this.calories = calories;
		this.fat = fat;
		this.saturatedFat = saturatedFat;
		this.transFat = transFat;
		this.carbohydrates = carbohydrates;
		this.fibre = fibre;
		this.sugars = sugars;
		this.protein = protein;
		this.cholesterol = cholesterol;
		this.sodium = sodium;
		this.potassium = potassium;
		this.calcium = calcium;
		this.iron = iron;
		this.vitaminD = vitaminD;
	}

	/** 
	 * getter of servingSize
	 * @return int servingSize
	 */
	public int getServingSize() {
		return servingSize;
	}

	/**
	 * setter of servingSize 
	 * @param servingSize the serving size for this NutritionInfo
	 */
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}

	/** 
	 * getter of unit
	 * @return String unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * setter of unit 
	 * @param unit the unit for this NutritionInfo
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/** 
	 * getter of calories
	 * @return double calories
	 */
	public double getCalories() {
		return calories;
	}

	/**
	 * setter of calories
	 * @param calories the calories for this NutritionInfo
	 */
	public void setCalories(double calories) {
		this.calories = calories;
	}

	/** 
	 * getter of fat
	 * @return double fat
	 */
	public double getFat() {
		return fat;
	}

	/**
	 * setter of fat
	 * @param fat the fat for this NutritionInfo
	 */
	public void setFat(double fat) {
		this.fat = fat;
	}

	/** 
	 * getter of saturatedFat
	 * @return double saturatedFat
	 */
	public double getSaturatedFat() {
		return saturatedFat;
	}

	/**
	 * setter of saturatedFat
	 * @param saturatedFat the saturatedFat for this NutritionInfo
	 */
	public void setSaturatedFat(double saturatedFat) {
		this.saturatedFat = saturatedFat;
	}

	/** 
	 * getter of transFat
	 * @return double transFat
	 */
	public double getTransFat() {
		return transFat;
	}

	/**
	 * setter of transFat
	 * @param transFat the transFat for this NutritionInfo
	 */
	public void setTransFat(double transFat) {
		this.transFat = transFat;
	}

	/** 
	 * getter of carbohydrates
	 * @return double carbohydrates
	 */
	public double getCarbohydrates() {
		return carbohydrates;
	}

	/**
	 * setter of carbohydrates
	 * @param carbohydrates the carbohydrates for this NutritionInfo
	 */
	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	/** 
	 * getter of fibre
	 * @return double fibre
	 */
	public double getFibre() {
		return fibre;
	}

	/**
	 * setter of fibre
	 * @param fibre the fibre for this NutritionInfo
	 */
	public void setFibre(double fibre) {
		this.fibre = fibre;
	}

	/** 
	 * getter of sugars
	 * @return double sugars
	 */
	public double getSugars() {
		return sugars;
	}

	/**
	 * setter of sugars
	 * @param sugars the sugars for this NutritionInfo
	 */
	public void setSugars(double sugars) {
		this.sugars = sugars;
	}

	/** 
	 * getter of protein
	 * @return double protein
	 */
	public double getProtein() {
		return protein;
	}

	/**
	 * setter of protein
	 * @param protein the protein for this NutritionInfo
	 */
	public void setProtein(double protein) {
		this.protein = protein;
	}

	/** 
	 * getter of cholesterol
	 * @return double cholesterol
	 */
	public double getCholesterol() {
		return cholesterol;
	}

	/**
	 * setter of cholesterol
	 * @param cholesterol the cholesterol for this NutritionInfo
	 */
	public void setCholesterol(double cholesterol) {
		this.cholesterol = cholesterol;
	}

	/** 
	 * getter of sodium
	 * @return double sodium
	 */
	public double getSodium() {
		return sodium;
	}

	/**
	 * setter of sodium
	 * @param sodium the sodium for this NutritionInfo
	 */
	public void setSodium(double sodium) {
		this.sodium = sodium;
	}

	/** 
	 * getter of potassium
	 * @return double potassium
	 */
	public double getPotassium() {
		return potassium;
	}

	/**
	 * setter of potassium
	 * @param potassium the potassium for this NutritionInfo
	 */
	public void setPotassium(double potassium) {
		this.potassium = potassium;
	}

	/** 
	 * getter of calcium
	 * @return double calcium
	 */
	public double getCalcium() {
		return calcium;
	}

	/**
	 * setter of calcium
	 * @param calcium the calcium for this NutritionInfo
	 */
	public void setCalcium(double calcium) {
		this.calcium = calcium;
	}

	/** 
	 * getter of iron
	 * @return double iron
	 */
	public double getIron() {
		return iron;
	}

	/**
	 * setter of iron
	 * @param iron the iron for this NutritionInfo
	 */
	public void setIron(double iron) {
		this.iron = iron;
	}
	
	/** 
	 * getter of vitaminD
	 * @return double vitaminD
	 */
	public double getVitaminD() {
		return vitaminD;
	}

	/**
	 * setter of vitaminD
	 * @param vitaminD the vitaminD for this NutritionInfo
	 */
	public void setVitaminD(double vitaminD) {
		this.vitaminD = vitaminD;
	}

	/**
	 * Computes the percentage of calories that come from fat.
	 * @return the fat percentage of total calories
	 */
	public double computeFatPercentage() {
		double fatCalories = this.fat * 9.0;
		return (fatCalories/this.calories) * 100.0;
	}
	
	/**
	 * Computes the percentage of calories that come from carbohydrates.
	 * @return the carbohydrate percentage of total calories
	 */
	public double computeCarbohydratePercentage() {
		double carbohydrateCalories = this.carbohydrates * 4.0;
		return (carbohydrateCalories/this.calories) * 100.0;
	}
	
	/**
	 * Computes the percentage of calories that come from protein.
	 * @return the protein percentage of total calories
	 */
	public double computeProteinPercentage() {
		double proteinCalories = this.protein * 4.0;
		return (proteinCalories/this.calories) * 100.0;
	}
	
	/**
	 * Determines if the food is a good source with at least 400mg of potassium per serving.
	 * @return {@code true} if potassium at least 400mg
	 */
	public boolean computeIsSourcePotassium() {
		return this.potassium >= 400.0;
	}
	
	/**
	 * Determines if the food is a good source with at least 100mg of calcium per serving.
	 * @return {@code true} if calcium at least 100mg
	 */
	public boolean computeIsSourceCalcium() {
		return this.calcium >= 100.0;
	}
	
	/**
	 * Determines if the food is a good source with at least 2mg of iron per serving.
	 * @return {@code true} if iron at least 2mg
	 */
	public boolean computeIsSourceIron() {
		return this.iron >= 2.0;
	}
	
	/**
	 * Determines if the food is a good source with at least 5g of fibre per serving.
	 * @return {@code true} if fibre at least 5g
	 */
	public boolean computeIsHighFibre() {
		return this.fibre >= 5.0;
	}
	
	/**
	 * Determines if the food is low in fat with less than 30% of fat per serving.
	 * @return {@code true} if fat less than 30%
	 */
	public boolean computeIsLowFat() {
		double fatPercent = computeFatPercentage();
		return fatPercent < 30.0;
	}
	
	/**
	 * Determines if the food is trans fat free with at most 0.2g of trans fat per serving.
	 * @return {@code true} if transFat at most 0.2g
	 */
	public boolean computeIsTransFatFree() {
		return this.transFat <= 0.2;
	}
	
	/**
	 * Generates a health report summarizing macronutrient percentages
	 * and nutrient source information.
	 * @return sb.toString() a multiline String containing the formatted health report
	 */
	public String printHealthReport() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Macronutrients:\n");
		sb.append(String.format("Fat: %.1f%%\n", computeFatPercentage()));
		sb.append(String.format("Carbohydrates: %.1f%%\n", computeCarbohydratePercentage()));
		sb.append(String.format("Protein: %.1f%%\n", computeProteinPercentage()));

		
		if(computeIsSourcePotassium()) {
			sb.append("This food is a good source of potassium.\n");
		}
		
		if(computeIsSourceCalcium()) {
			sb.append("This food is a good source of calcium.\n");
		}
		
		if(computeIsSourceIron()) {
			sb.append("This food is a good source of iron.\n");
		}
		
		if(computeIsHighFibre()) {
			sb.append("This food is a good source of fibre.\n");
		}
		
		if(computeIsLowFat()) {
			sb.append("This food is a low fat food.\n");
		}
		
		if(computeIsTransFatFree()) {
			sb.append("This food is trans fat free.\n");
		}
			
		return sb.toString();
	}
	
	/**
	 * Generates a full nutrition label with all nutrient values scaled by the given multiplier.
	 * @param multiplier a factor by which to scale all nutrient values
	 * @return sb.toString() a multiline String containing the formatted nutrition facts label
	 * */
	public String printLabel(double multiplier) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Nutrition Facts\n");
		sb.append(String.format("Per %d %s%nCalories %.1f%n", (int)(this.servingSize * multiplier), unit, this.calories * multiplier));
		sb.append("-----------------\n");
		sb.append(String.format("Fat %.1f g%nSaturated %.1f g%nTrans %.1f g%n", this.fat * multiplier, this.saturatedFat * multiplier, this.transFat * multiplier));
		sb.append("-----------------\n");
		sb.append(String.format("Carbohydrates %.1f g%nFibre %.1f g%nSugars %.1f g%n", this.carbohydrates * multiplier, this.fibre * multiplier, this.sugars * multiplier));
		sb.append("-----------------\n");
		sb.append(String.format("Protein %.1f g%n", this.protein * multiplier));
		sb.append("-----------------\n");
		sb.append(String.format("Cholesterol %.1f mg%nSodium %.1f mg%n", this.cholesterol * multiplier, this.sodium * multiplier));
		sb.append("-----------------\n");
		sb.append(String.format("Potassium %.1f mg%nCalcium %.1f mg%nIron %.1f mg%nVitamin D %.1f mg%n", this.potassium * multiplier, this.calcium * multiplier, this.iron * multiplier, this.vitaminD * multiplier));
		sb.append("-----------------\n");
		return sb.toString();
	}
	
	/** 
	 * Overloaded of printLabel() method that uses a multiplier of 1.0,
	 * to prints the label for a single serving without scaling.
	 * @return printLabel() a multiline String containing the formatted nutrition facts label for one full serving
	 */
	public String printLabel() {
		return printLabel(1.0);
	}
}
