// eye is the location of the camera (xyz)
// target is where the camera is looking (forwardVectors)
// y is for which direction is up (0.0f, 1.0f, 0.0f)
public Matrix3D lookAt(Point3D eye, Point3D target, Vector3D y) {
	Vector3D eyeV = new Vector3D(eye);
	Vector3D targetV = new Vector3D(target);
	Vector3D fwd = (targetV.minus(eyeV)).normalize();
	Vector3D side = (fwd.cross(y)).normalize();
	Vector3D up = (side.cross(fwd)).normalize();

	Matrix3D look = new Matrix3D();
	look.setElementAt(0, 0, side.getX());
	look.setElementAt(1, 0, up.getX());
	look.setElementAt(2, 0,	-fwd.getX());
	look.setElementAt(3, 0, 0.0f);
	look.setElementAt(0, 1, side.getY());
	look.setElementAt(1, 1, up.getY());
	look.setElementAt(2, 1, -fwd.getY());
	look.setElementAt(3, 1, 0.0f);
	look.setElementAt(0, 2, side.getZ());
	look.setElementAt(1, 2, up.getZ());
	look.setElementAt(2, 2, -fwd.getZ());
	look.setElementAt(3, 2, 0.0f);
	look.setElementAt(0, 3, side.dot(eyeV.mult(-1)));
	look.setElementAt(1, 3, up.dot(eyeV.mult(-1)));
	look.setElementAt(2, 3, (fwd.mult(-1)).dot(eyeV.mult(-1)));
	look.setElementAt(3, 3, 1.0f);
	return look;
	}
