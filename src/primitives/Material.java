package primitives;

/**
 * material class
 *
 */
public class Material {
//fields: diffusive and specular and transparency and reflectivity and shininess
/**
 * field: diffusive
 */
public Double3 kD=Double3.ZERO;
/**
 * field: specular
 */
public Double3 kS=Double3.ZERO;
/**
 * field: transparency 
 */
public Double3 kT=Double3.ZERO;
/**
 * field: reflectivity
 */
public Double3 kR=Double3.ZERO;
/**
 * field: shininess
 */
public int nShininess=0;

/**
 * setKd function
 * @param kD diffusive factor - double3
 * @return this
 */
public Material setKd(Double3 kD) {
	this.kD = kD;
	return this;
}
/**
 * setKs function
 * @param kS specular factor v- double3
 * @return this
 */
public Material setKs(Double3 kS) {
	this.kS = kS;
	return this;

}
/**
 * setKt function
 * @param kt transparency factor - double3
 * @return this
 */
public Material setKt(Double3 kt) {
	this.kT = kt;
	return this;
}
/**
 * setKr function
 * @param kr reflectivity factor - double3
 * @return this
 */
public Material setKr(Double3 kr) {
	this.kR = kr;
	return this;
}
/**
 * set shininess function
 * @param nShininess factor - int
 * @return this
 */
public Material setShininess(int nShininess) {
	this.nShininess = nShininess;
	return this;

}
/**
 * setKd function
 * @param kD diffusive factor - double
 * @return this
 */
public Material setKd(Double kD) {
	this.kD = new Double3(kD);
	return this;
}
/**
 * setKs function
 * @param kS specular factor v- double
 * @return this
 */
public Material setKs(Double kS) {
	this.kS = new Double3(kS);
	return this;

}
/**
 * setKt function
 * @param kt transparency factor - double
 * @return this
 */
public Material setKt(double kt) {
	this.kT = new Double3(kt);
	return this;
}
/**
 * setKr function
 * @param kr reflectivity factor - double
 * @return this
 */
public Material setKr(double kr) {
	this.kR = new Double3(kr);
	return this;
}


}
