package com.android.dialer2.callrecord;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICallRecorderService extends IInterface {

    public static abstract class Stub extends Binder implements ICallRecorderService {
        private static final String DESCRIPTOR = "com.android.dialer2.callrecord.ICallRecorderService";
        static final int TRANSACTION_getActiveRecording = 4;
        static final int TRANSACTION_isRecording = 3;
        static final int TRANSACTION_startRecording = 1;
        static final int TRANSACTION_stopRecording = 2;

        private static class Proxy implements ICallRecorderService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public boolean startRecording(String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    boolean z = false;
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public CallRecording stopRecording() throws RemoteException {
                CallRecording callRecording;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        callRecording = CallRecording.CREATOR.createFromParcel(obtain2);
                    } else {
                        callRecording = null;
                    }
                    return callRecording;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isRecording() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public CallRecording getActiveRecording() throws RemoteException {
                CallRecording callRecording;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        callRecording = CallRecording.CREATOR.createFromParcel(obtain2);
                    } else {
                        callRecording = null;
                    }
                    return callRecording;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICallRecorderService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ICallRecorderService)) {
                return new Proxy(iBinder);
            }
            return (ICallRecorderService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean startRecording = startRecording(parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(startRecording ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        CallRecording stopRecording = stopRecording();
                        parcel2.writeNoException();
                        if (stopRecording != null) {
                            parcel2.writeInt(1);
                            stopRecording.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isRecording = isRecording();
                        parcel2.writeNoException();
                        parcel2.writeInt(isRecording ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        CallRecording activeRecording = getActiveRecording();
                        parcel2.writeNoException();
                        if (activeRecording != null) {
                            parcel2.writeInt(1);
                            activeRecording.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    CallRecording getActiveRecording() throws RemoteException;

    boolean isRecording() throws RemoteException;

    boolean startRecording(String str, long j) throws RemoteException;

    CallRecording stopRecording() throws RemoteException;
}