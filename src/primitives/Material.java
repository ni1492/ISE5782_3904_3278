package primitives;

/**
 * material class
 *
 */
public class Material {
//fields: diffusive and specular and shininess
public Double3 kD= Double3.ZERO;
public Double3 kS=Double3.ZERO;
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


}
