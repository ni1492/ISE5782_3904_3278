package primitives;

public class Material {
public Double3 kD= Double3.ZERO;
public Double3 kS=Double3.ZERO;
public int nShininess=0;

/**
 * 
 * @param kD
 */
public Material setKd(Double3 kD) {
	this.kD = kD;
	return this;
}
/**
 * 
 * @param kS
 */
public Material setKs(Double3 kS) {
	this.kS = kS;
	return this;

}
/**
 * 
 * @param nShininess
 */
public Material setShininess(int nShininess) {
	this.nShininess = nShininess;
	return this;

}
/**
 * 
 * @param kD
 */
public Material setKd(Double kD) {
	this.kD = new Double3(kD);
	return this;
}
/**
 * 
 * @param kS
 */
public Material setKs(Double kS) {
	this.kS = new Double3(kS);
	return this;

}


}
